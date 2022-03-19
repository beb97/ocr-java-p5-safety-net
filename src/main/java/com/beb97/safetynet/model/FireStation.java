package com.beb97.safetynet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class FireStation {
    @Id
    @GeneratedValue
    private int id;
    String station;
    String address;
}
