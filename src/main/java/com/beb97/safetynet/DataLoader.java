package com.beb97.safetynet;

import com.beb97.safetynet.repository.FireStationDao;
import com.beb97.safetynet.repository.MedicalRecordDao;
import com.beb97.safetynet.repository.PersonDao;
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

    String jsonFileName = "src/main/resources/data.json";
    ObjectMapper objectMapper;
    JsonNode jsonTree;

    DataLoader() {
        objectMapper = new ObjectMapper();
        File jsonFile = new File(jsonFileName);
        try {
            jsonTree = objectMapper.readTree(jsonFile);
        }catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {

        }
    }

    public void run(ApplicationArguments args) {
        if (null != jsonTree) {
            try {
                List<Person> persons = getListFromJson("persons", Person.class);
                personDao.saveAll(persons);

                List<FireStation> fireStations = getListFromJson("firestations", FireStation.class);
                fireStationDao.saveAll(fireStations);

                List<MedicalRecord> medicalRecords = getListFromJson("medicalrecords", MedicalRecord.class);
                medicalRecordDao.saveAll(medicalRecords);

            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
            }
        }
    }

    public <T> List<T> getListFromJson(String nodeName, Class<T> nodeClass) throws IOException {
        List list = new ArrayList<T>();
        for(JsonNode jsonNode : jsonTree.get(nodeName)) {
            list.add(objectMapper.treeToValue(jsonNode, nodeClass));
        }
        return list;
    }
}
