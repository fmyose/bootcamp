package com.example.mod6a4pi2elasticsearch.controller;

import com.example.mod6a4pi2elasticsearch.model.Employee;
import com.example.mod6a4pi2elasticsearch.model.dto.EmployeeDTO;
import com.example.mod6a4pi2elasticsearch.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/employee")
    public ResponseEntity<String> save(@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = modelMapper.map(employeeDTO, Employee.class);
        employeeService.save(newEmployee);

        return new ResponseEntity<>(newEmployee.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeeDTO> findById(@RequestParam String id) {
        EmployeeDTO employeeDTO = modelMapper.map(employeeService.findById(id), EmployeeDTO.class);

        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable(value = "id") String id, @RequestBody Map<Object, Object> newFieldValues) {
        Employee employee = employeeService.findById(id);
        // https://stackoverflow.com/questions/45200142/spring-rest-partial-update-with-patch-method
        // TODO it does not work with the address - fails for nested object
        newFieldValues.forEach((k,v) -> {
                    Field field = ReflectionUtils.findField(Employee.class, (String) k);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, employee, v);
                }
        );
        employeeService.save(employee);
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

        return ResponseEntity.ok(employeeDTO);
    }

}
