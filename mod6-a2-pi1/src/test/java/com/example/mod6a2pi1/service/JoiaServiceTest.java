package com.example.mod6a2pi1.service;

import com.example.mod6a2pi1.model.Joia;
import com.example.mod6a2pi1.model.dto.JoiaDTO;
import com.example.mod6a2pi1.repository.JoiaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JoiaServiceTest {

    @Mock
    private JoiaRepository joiaRepository;

    @InjectMocks
    private JoiaService joiaService;

    @Test
    void get() {
        List<Joia> expectedJoia = new ArrayList<>(
                Arrays.asList(
                        new Joia(1L, "mat1", 10.0,20.0),
                        new Joia(2L,"mat2", 10.0,20.0)
                )
        );
        Mockito.when(joiaRepository.findAll()).thenReturn(expectedJoia);
        List<Joia> actualJoia = joiaService.get();

        assertEquals(expectedJoia, actualJoia);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void find() {
    }

    @Test
    void update() {
    }

}
