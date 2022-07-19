package com.traballhounid02.trabalho02.repositories;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.traballhounid02.trabalho02.models.Paciente;

@Repository

public interface PacienteRepository extends ReactiveCrudRepository<Paciente, Long> {
}
