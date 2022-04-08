package com.example.mod6a3pi1.service;

import com.example.mod6a3pi1.model.TestCase;
import com.example.mod6a3pi1.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    TestCaseRepository testCaseRepository;


    @Override
    public List<TestCase> get() {
        return testCaseRepository.findAll();
    }

    @Override
    public void save(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public TestCase find(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public TestCase update(Long id, TestCase testCase) {
        TestCase testCaseToUpdate = find(id);
        testCaseToUpdate = testCase;
        save(testCaseToUpdate);
        return testCaseToUpdate;
    }

    @Override
    public List<TestCase> findBySinceDate(Date date) {
        List<TestCase> testcases = testCaseRepository.findTestCasesByLastUpdateAfter(date);
        return testcases;
    }
}
