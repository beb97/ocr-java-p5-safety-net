package com.beb97.safetynet;

import com.beb97.safetynet.dao.PersonDao;
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

    public void run(ApplicationArguments args) {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerFor(new TypeReference<List<Person>>() {});
        List<Person> persons = new ArrayList<>();

        JsonNode jsonNode;
        try {
            File jsonFile = new File("src/main/resources/data.json");
            jsonNode = objectMapper.readTree(jsonFile);
            persons = objectReader.readValue(jsonNode.get("persons"));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
        }

        personDao.saveAll(persons);
    }
}
