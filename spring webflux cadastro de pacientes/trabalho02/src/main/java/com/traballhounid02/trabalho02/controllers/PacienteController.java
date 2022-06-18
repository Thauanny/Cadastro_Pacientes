package com.traballhounid02.trabalho02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.traballhounid02.trabalho02.dto.RequestNewPacientDTO;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.services.PacienteService;



@Controller
public class PacienteController {

    @Autowired  
    private PacienteService pacienteService;

    @GetMapping(path  = "/cadastro_pacientes")
    public String findAll(final Model model) {

        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
            new ReactiveDataDriverContextVariable( this.pacienteService.findAll());
  
        model.addAttribute("pacientes", reactiveDataDrivenMode);

        return "pacientes/index";
    }

    @GetMapping(value = "/cadastro_pacientes/new")
    public String newPacient() {

        return "pacientes/new";

    }

    @PostMapping(value = "/cadastro_pacientes")
    public String create(RequestNewPacientDTO req) {
        Paciente paciente = req.toPaciente();
        this.pacienteService.save(paciente);
        return "redirect:http://localhost:9000/CADASTROPACIENTESWEBFLUX/cadastro_pacientes";
    }

}
