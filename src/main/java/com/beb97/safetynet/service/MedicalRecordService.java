package com.beb97.safetynet.service;

import com.beb97.safetynet.repository.MedicalRecordDao;
import com.beb97.safetynet.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordDao medicalRecordDao;

//    https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot/7078015-creez-un-controleur-rest-pour-gerer-vos-donnees

    public Iterable<MedicalRecord> getAll() {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person());
        return medicalRecordDao.findAll();
    }

    public Optional<MedicalRecord> getById(Integer id) {
        return medicalRecordDao.findById(id);
    }
}
