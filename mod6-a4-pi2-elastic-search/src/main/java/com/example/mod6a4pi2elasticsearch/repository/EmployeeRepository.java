package com.example.mod6a4pi2elasticsearch.repository;

import com.example.mod6a4pi2elasticsearch.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    // findAll() was returning Iterable - overriding to return a List
    @Override
    List<Employee> findAll();
}
