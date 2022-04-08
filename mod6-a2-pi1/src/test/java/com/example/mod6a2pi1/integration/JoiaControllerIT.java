package com.example.mod6a2pi1.integration;

import com.example.mod6a2pi1.model.dto.JoiaDTO;
import com.example.mod6a2pi1.repository.JoiaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JoiaControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JoiaRepository joiaRepository;

    @Autowired
    ObjectMapper objectMapper;

    public void inserirNovo() throws Exception {

        JoiaDTO joiaDTO = new JoiaDTO("mat1", 10.0, 20.0);

        String joiaString = objectMapper.writeValueAsString(joiaDTO);
        mockMvc.perform(post("/joia/inserir")
                .contentType("/application/json")
                .content(joiaString))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(".id").value(1));

    }
}
