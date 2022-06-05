package com.traballhounid02.trabalho02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.repositories.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return this.pacienteRepository.findAll();
    } 

    public void save(Paciente paciente){
        this.pacienteRepository.save(paciente);
    }

    
     
}
