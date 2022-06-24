package com.beb97.safetynet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 3, max = 25)
    String firstName;
    String lastName;
    String address;
    String city;
    Integer zip;
    String phone;
    String email;

    // constructeur
    public Person(String firstName, String lastName, String address, String city, Integer zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        this("Pierre", "Bébon");
//        this.firstName = "pierre";
//        this.lastName = "bébon";
//        this.address = "21 la rouaudiere";
//        this.city = "paris";
//        this.zip = 44900;
//        this.phone = "0614364136";
//        this.email = "bebon.pierre@gmail";
    }
}

