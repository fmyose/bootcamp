package com.example.mod6a4pi2elasticsearch.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "employee")
@Getter
@Setter
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Address address;
}
