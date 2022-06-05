package com.traballhounid02.trabalho02.repositories;

import org.springframework.stereotype.Repository;

import com.traballhounid02.trabalho02.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    
}
