package com.example.mod6a3pi1.controller;

import com.example.mod6a3pi1.model.TestCase;
import com.example.mod6a3pi1.model.TestCaseDTO;
import com.example.mod6a3pi1.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCaseDTO> newTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCaseService.save(testCase);

        return new ResponseEntity<>(testCaseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDTO>> getAll() {
        List<TestCase> testCases = testCaseService.get();
        List<TestCaseDTO> testCaseDTOS = testCases.stream().map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(testCaseDTOS);
    }

    @GetMapping("/api/testcases/id")
    public ResponseEntity<TestCase> getTestCaseById(@RequestParam Long id) {
       TestCase testCase = testCaseService.find(id);

       return ResponseEntity.ok(testCase);
    }

    @PutMapping("/api/testcases/id")
    public ResponseEntity<TestCaseDTO> updateTestCase(@RequestBody TestCaseDTO testCaseDTO, @RequestParam Long id) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCaseService.update(id, testCase);

        return ResponseEntity.ok(testCaseDTO);
    }

    @DeleteMapping("/api/testcases/id")
    public ResponseEntity<String> deleteTestCase(@RequestParam Long id) {
        testCaseService.delete(id);

        return ResponseEntity.ok("Test Case deleted.");
    }

    @GetMapping("/api/testcases/date")
    public ResponseEntity<List<TestCase>> getTestCaseSinceDate(@RequestParam Date date) {
        List<TestCase> testCases = testCaseService.findBySinceDate(date);

        return ResponseEntity.ok(testCases);
    }
}
