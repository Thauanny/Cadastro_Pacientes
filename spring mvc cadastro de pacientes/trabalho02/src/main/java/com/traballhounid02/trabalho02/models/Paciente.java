package com.traballhounid02.trabalho02.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String symptoms;
    @Column(nullable = false)
    private String situation;

    public Paciente() {

    }
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
