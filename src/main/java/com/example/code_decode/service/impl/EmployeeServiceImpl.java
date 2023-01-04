package com.example.code_decode.service.impl;

import com.example.code_decode.domain.model.response.EmployeeResponse;
import com.example.code_decode.repository.EmployeeRepository;
import com.example.code_decode.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        log.info("EmployeeServiceImpl:getAllEmployee: Fetching all the employee from the db");
        return employeeRepository.findAll().stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }
}
