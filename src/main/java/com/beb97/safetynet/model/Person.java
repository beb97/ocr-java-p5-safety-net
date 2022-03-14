package com.beb97.safetynet.model;

import lombok.Data;

@Data
public class Person {
    String firstName;
    String lastName;
    String address;
    String city;
    Integer zip;
    String phone;
    String email;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        this("Pierre", "Bébon");
    }
}

