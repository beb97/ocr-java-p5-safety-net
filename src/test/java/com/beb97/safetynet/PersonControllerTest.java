package com.beb97.safetynet;

import com.beb97.safetynet.controller.PersonController;
import com.beb97.safetynet.model.Person;
import com.beb97.safetynet.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService service;

    @Test
    public void testGetAll() throws Exception {
        Person person = new Person("Toto","Bébon");
        List<Person> result = new ArrayList<>();
        result.add(person);
        result.add(new Person());

        when(service.getAll()).thenReturn(result);

        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName").value("Toto"));
    }

    @Test
    public void testGetHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetWithResult() throws Exception {
        Person person = new Person("Toto","Bébon");
        when(service.getById(1)).thenReturn(person);

        mockMvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Toto"));
    }

    @Test
    public void testGetWithNoMatch() throws Exception {
        Person person = null;
        when(service.getById(1)).thenReturn(person);

        mockMvc.perform(get("/person/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testSaveSuccess() throws Exception {
        Person person = new Person();
        ObjectMapper objectMapper = new ObjectMapper();
        when(service.save(person)).thenReturn(person);

//        https://www.baeldung.com/http-put-patch-difference-spring
        mockMvc.perform(
                post("/person/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(person))
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void testSaveError() throws Exception {
        Person person = new Person("T", "Nom");
        ObjectMapper objectMapper = new ObjectMapper();

        when(service.save(person)).thenReturn(null);

        mockMvc.perform(post("/person/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(person))
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void testUpdateSuccess() throws Exception {
        Person person = new Person();
        Integer id = 1;
        ObjectMapper objectMapper = new ObjectMapper();

        when(service.update(person, id)).thenReturn(true);

        mockMvc.perform(put("/person/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(person))
                )
                .andExpect(status().isNoContent());
    }


    @Test
    public void testUpdateError() throws Exception {
        Person person = new Person();
        Integer id = 1;
        ObjectMapper objectMapper = new ObjectMapper();

        when(service.update(person, id)).thenReturn(false);

        mockMvc.perform(put("/person/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(person))
        )
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteSuccess() throws Exception {
        mockMvc.perform(delete("/person/1"))
                .andExpect(status().isNoContent());
    }
}
