package com.example.mod6a3pi1.repository;

import com.example.mod6a3pi1.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findTestCasesByLastUpdateAfter(Date date);
}
