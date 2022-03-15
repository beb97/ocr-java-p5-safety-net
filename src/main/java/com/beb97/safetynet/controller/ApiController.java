package com.beb97.safetynet.controller;

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
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String getHome() {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerFor(new TypeReference<List<Person>>() {});
        List<Person> persons = new ArrayList<>();

        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(new File("src/main/resources/data.json"));
            persons = objectReader.readValue(jsonNode.get("persons"));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
        }

        return "yo";
    }

    @GetMapping("/all")
    public Iterable<Person> getAll() {

        return apiService.getAll();
//        return apiService.getAll();
    }

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return apiService.getAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") Integer id) {
        Person person = null;
        if (apiService.getPerson(id).isPresent()) {
            person = apiService.getPerson(id).get();
        }
        return person;
    }

    @PostMapping("/person")
    public void createPerson(@ModelAttribute Person person) {
        return ;
    }

    @PutMapping("/person")
    public void updatePerson(@ModelAttribute Person person) {
        return ;
    }
}
