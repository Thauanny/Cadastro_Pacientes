package com.traballhounid02.trabalho02.utils;

import com.github.javafaker.Faker;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Faker faker(){
        return FAKER;
    }

    
}
