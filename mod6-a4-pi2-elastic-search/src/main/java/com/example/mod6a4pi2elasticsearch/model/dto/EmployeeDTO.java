package com.example.mod6a4pi2elasticsearch.model.dto;

import com.example.mod6a4pi2elasticsearch.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String surname;
    private Integer age;
    private Address address;
}
