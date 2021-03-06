package com.beb97.safetynet.controller;

import com.beb97.safetynet.repository.MedicalRecordDao;
import com.beb97.safetynet.model.MedicalRecord;
import com.beb97.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalRecordController {

    @Autowired
    private PersonService apiService;

    @Autowired
    private MedicalRecordDao medicalRecordDao;


    @GetMapping("/medicalrecord")
    public Iterable<MedicalRecord> getAll() {
        return medicalRecordDao.findAll();
    }

    @GetMapping("/medicalrecord/{id}")
    public MedicalRecord getById(@PathVariable("id") Integer id) {
        MedicalRecord medicalRecord = null;
//        if (apiService.getPerson(id).isPresent()) {
        medicalRecord = medicalRecordDao.findById(id).get();
//        }
        return medicalRecord;
    }

    @PostMapping("/medicalrecord")
    public void create(@ModelAttribute MedicalRecord medicalRecord) {
        return ;
    }

    @PutMapping("/medicalrecord")
    public void update(@ModelAttribute MedicalRecord medicalRecord) {
        return ;
    }
}
