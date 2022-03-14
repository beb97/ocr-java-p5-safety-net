package com.beb97.safetynet.service;

import com.beb97.safetynet.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {


//    https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot/7078015-creez-un-controleur-rest-pour-gerer-vos-donnees

    public Iterable<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        return persons;
    }
}
