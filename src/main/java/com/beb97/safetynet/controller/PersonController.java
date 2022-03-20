package com.beb97.safetynet.controller;

import com.beb97.safetynet.model.Person;
import com.beb97.safetynet.service.PersonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String getHome() {
        return "home sweet home";
    }

    @GetMapping("/person")
    public Iterable<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Integer id) {
        Person person = personService.getById(id);
        if (null == person) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person personSaved = personService.save(person);
        if (null == personSaved) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Object> update(@RequestBody Person personne,
                       @PathVariable("id") Integer id) {
        Boolean updated = personService.update(personne, id);
        if (!updated) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable("id") Integer id) {
        personService.deleteById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
