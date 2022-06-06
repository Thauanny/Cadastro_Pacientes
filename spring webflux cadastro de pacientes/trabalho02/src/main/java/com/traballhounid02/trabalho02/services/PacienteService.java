package com.traballhounid02.trabalho02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.repositories.PacienteRepository;
import reactor.core.publisher.Flux;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public Flux<Paciente> findAll(){
        return this.pacienteRepository.findAll();
    } 

    public void save(Paciente paciente){
        this.pacienteRepository.save(paciente).subscribe();
    }

    
     
}
