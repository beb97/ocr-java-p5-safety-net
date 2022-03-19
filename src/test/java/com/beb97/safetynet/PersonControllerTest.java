package com.beb97.safetynet;

import com.beb97.safetynet.controller.PersonController;
import com.beb97.safetynet.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {

        mockMvc.perform(get("/person/1"))
                .andExpect(status().isOk());
    }
}
