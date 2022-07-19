package com.traballhounid02.trabalho02.models;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("paciente")
public class Paciente {
    @Id
    private Long id;

    private String name;

    private String age;

    private String symptoms;

    private String situation;


    public Long getId() {
        return this.id;
    }

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

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(String age) {
      this.age = age;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }



    @Override
    public String toString() {

        return "Paciente{" +
                "id=" + id +
                ", nome=" + name + "\"" + ", sintomas=" + symptoms + ", situação=" + situation + ", idade=" + age +"}";
    }

}
