package com.beb97.safetynet.controller;

import com.beb97.safetynet.repository.FireStationDao;
import com.beb97.safetynet.model.FireStation;
import com.beb97.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirestationController {

    @Autowired
    private PersonService apiService;

    @Autowired
    private FireStationDao fireStationDao;


    @GetMapping("/firestation")
    public Iterable<FireStation> getAll() {
        return fireStationDao.findAll();
    }

    @GetMapping("/firestation/{id}")
    public FireStation getById(@PathVariable("id") Integer id) {
        FireStation fireStation = null;
//        if (apiService.getPerson(id).isPresent()) {
        fireStation = fireStationDao.findById(id).get();
//        }
        return fireStation;
    }

    @PostMapping("/firestation")
    public void create(@ModelAttribute FireStation fireStation) {
        return ;
    }

    @PutMapping("/firestation")
    public void update(@ModelAttribute FireStation fireStation) {
        return ;
    }
}
