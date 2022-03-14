package com.beb97.safetynet.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MedicalRecord {
    String firstName;
    String lastName;
    Date birthdate;
    List<String> medications;
    List<String> allergies;
}
