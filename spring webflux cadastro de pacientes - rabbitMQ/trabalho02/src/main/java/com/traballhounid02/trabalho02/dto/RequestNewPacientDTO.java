package com.traballhounid02.trabalho02.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.traballhounid02.trabalho02.models.Paciente;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RequestNewPacientDTO {
    private String name;
    private String age;
    private String symptoms;
    private String situation;

    RequestNewPacientDTO(String name, String age, String symptoms, String situation) {
        this.name = name;
        this.age = age;
        this.situation = situation;
        this.symptoms = symptoms;
    };

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getSymptoms() {
        return this.symptoms;
    }

    public String getSituation() {
        return this.situation;
    }

    @Override
    public String toString() {

        return "Paciente{" + "nome=" + name + "\"" + ", sintomas=" + symptoms + ", situação=" + situation + ", idade="
                + age
                + "}";
    }

    public Paciente toPaciente() {
        Paciente paciente = new Paciente();
        paciente.setName(this.name);
        paciente.setAge(this.age);
        paciente.setSituation(this.situation);
        paciente.setSymptoms(this.symptoms);
        return paciente;

    }

}
