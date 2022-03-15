package com.beb97.safetynet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
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

