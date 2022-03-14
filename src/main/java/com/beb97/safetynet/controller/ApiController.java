package com.beb97.safetynet.controller;

import com.beb97.safetynet.model.Person;
import com.beb97.safetynet.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String getHome() {
        return "yo";
    }

    @GetMapping("/all")
    public Iterable<Person> getAll() {
        return apiService.getAll();
    }
}
