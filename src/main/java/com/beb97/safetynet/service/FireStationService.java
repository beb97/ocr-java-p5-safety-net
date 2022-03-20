package com.beb97.safetynet.service;

import com.beb97.safetynet.repository.FireStationDao;
import com.beb97.safetynet.model.FireStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FireStationService {

    @Autowired
    FireStationDao fireStationDao;

//    https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot/7078015-creez-un-controleur-rest-pour-gerer-vos-donnees

    public Iterable<FireStation> getAll() {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person());
        return fireStationDao.findAll();
    }

    public Optional<FireStation> getById(Integer id) {
        return fireStationDao.findById(id);
    }
}
