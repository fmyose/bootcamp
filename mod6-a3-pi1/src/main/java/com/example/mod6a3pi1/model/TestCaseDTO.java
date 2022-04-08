package com.example.mod6a3pi1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {

    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private Date lastUpdate;

    public static TestCase convert(TestCaseDTO testCaseDTO) {
        return null;
    }
}
