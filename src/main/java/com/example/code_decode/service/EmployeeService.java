package com.example.code_decode.service;

import com.example.code_decode.domain.model.response.EmployeeResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployee();
    List<String> getNames();

    Set<String> getNonDuplicateNames();

    Set<String> getDuplicateNames();

    Map<String,Long> groupByNames();
    Map<String,Long> groupByNames_2();

    String findFirstDumplicateEmployeeName();

    String findFirstDumplicateEmployeeNameUsingCollectionFrequency();

    String findEmployeeById(Long id);
}
