package com.traballhounid02.trabalho02.controllers;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.traballhounid02.trabalho02.dto.RequestNewPacientDTO;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.services.PacienteService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reception")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private KafkaTemplate<String, Paciente> kafka;
    private final String KAFKA_TOPIC = "reception";

    @GetMapping(path = "/pacientes")
    public Flux<Paciente> findAll() {
        return this.pacienteService.findAll();

    }

    @PostMapping(value = "/cadastro_paciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Paciente> create(@Valid @RequestBody RequestNewPacientDTO pacientDTO) {
        Paciente paciente = pacientDTO.toPaciente();
        return this.pacienteService.save(paciente);
    }

    @GetMapping(path = "/emergencias")
    @CircuitBreaker(name = "cadastroPacientesCB", fallbackMethod = "erroPageDefault")
    public Flux<Paciente> emergencias() {
        Flux<Paciente> response = WebClient.create()
                .get().uri("http://localhost:9000/EMERGENCIASSERVICE/emergencias/").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(Paciente.class)
                .doOnError(ex -> {
                    throw new RuntimeException("the exception message is - " + ex.getMessage());
                });

        response.subscribe(a -> {
            kafka.send(KAFKA_TOPIC, a);
            System.out.println("ENVIO DE MENSAGEM: " + a);
        });

        return response;

    }

    @GetMapping(path = "/leves")
    @CircuitBreaker(name = "cadastroPacientesCB", fallbackMethod = "erroPageDefault")
    public Flux<Paciente> leves() {
    return WebClient.builder().build()
    .get().uri("http://localhost:9000/LEVESSERVICE/leves/").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Paciente.class)
    .doOnError(ex -> {
    throw new RuntimeException("the exception message is - "+ex.getMessage());
    });

    }

    public Flux<Paciente> erroPageDefault(Throwable e) {
        System.out.println("CIRCUIT BREAKERRRR");
        return this.pacienteService.findAll();
    }

}
