package com.beb97.safetynet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue
    private int id;
    String firstName;
    String lastName;
//    Date birthdate;
    String birthdate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "MEDICAL_RECORD_MEDICATIONS ", joinColumns = @JoinColumn(name = "MEDICAL_RECORD_ID"))
    @Column(name = "MEDICATIONS")
    List<String> medications = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "MEDICAL_RECORD_ALLERGIES", joinColumns = @JoinColumn(name = "MEDICAL_RECORD_ID"))
    @Column(name = "ALLERGIES")
    List<String> allergies = new ArrayList<>();
}
