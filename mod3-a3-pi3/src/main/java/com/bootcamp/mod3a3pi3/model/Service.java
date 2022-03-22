package com.bootcamp.mod3a3pi3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private double kilometers;
    private String descriptions;
}
