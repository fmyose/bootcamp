package com.example.mod6a3pi1.service;

import com.example.mod6a3pi1.model.TestCase;

import java.util.Date;
import java.util.List;

public interface ITestCaseService {
    public List<TestCase> get();
    public void save(TestCase testCase);
    public void delete(Long id);
    public TestCase find(Long id);
    public TestCase update(Long id, TestCase testCase);

    List<TestCase> findBySinceDate(Date date);
}
