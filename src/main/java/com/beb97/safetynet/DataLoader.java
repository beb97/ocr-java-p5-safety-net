package com.beb97.safetynet;

import com.beb97.safetynet.dao.FireStationDao;
import com.beb97.safetynet.dao.MedicalRecordDao;
import com.beb97.safetynet.dao.PersonDao;
import com.beb97.safetynet.model.FireStation;
import com.beb97.safetynet.model.MedicalRecord;
import com.beb97.safetynet.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonDao personDao;
    @Autowired
    FireStationDao fireStationDao;
    @Autowired
    MedicalRecordDao medicalRecordDao;

    public void run(ApplicationArguments args) {

        ObjectMapper objectMapper = new ObjectMapper();


        JsonNode jsonNode;
        try {
            File jsonFile = new File("src/main/resources/data.json");
            jsonNode = objectMapper.readTree(jsonFile);

            List<Person> persons = new ArrayList<>();
            ObjectReader personReader = objectMapper.readerFor(new TypeReference<List<Person>>() {});
            persons = personReader.readValue(jsonNode.get("persons"));
            personDao.saveAll(persons);

            List<FireStation> fireStations = new ArrayList<>();
            ObjectReader fireStationReader = objectMapper.readerFor(new TypeReference<List<FireStation>>() {});
            fireStations = fireStationReader.readValue(jsonNode.get("firestations"));
            fireStationDao.saveAll(fireStations);

            ObjectReader medicalRecordReader = objectMapper.readerFor(new TypeReference<List<MedicalRecord>>() {});
            List<MedicalRecord> medicalRecords = new ArrayList<>();
            medicalRecords = medicalRecordReader.readValue(jsonNode.get("medicalrecords"));
            medicalRecordDao.saveAll(medicalRecords);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
        }

    }
}
