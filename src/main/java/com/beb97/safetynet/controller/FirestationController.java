package com.beb97.safetynet.controller;

import com.beb97.safetynet.dao.FireStationDao;
import com.beb97.safetynet.model.FireStation;
import com.beb97.safetynet.model.Person;
import com.beb97.safetynet.service.ApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FirestationController {

    @Autowired
    private ApiService apiService;

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
