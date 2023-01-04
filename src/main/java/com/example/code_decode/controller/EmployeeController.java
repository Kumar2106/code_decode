package com.example.code_decode.controller;

import com.example.code_decode.domain.model.response.EmployeeResponse;
import com.example.code_decode.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames(){
        return ResponseEntity.ok(employeeService.getNames());
    }

    @GetMapping("/unique-names")
    public ResponseEntity<Set<String>> getNonDuplicateNames(){
        return ResponseEntity.ok(employeeService.getNonDuplicateNames());
    }

    @GetMapping("/duplicate-names")
    public ResponseEntity<Set<String>> getDuplicateNames(){
        return ResponseEntity.ok(employeeService.getDuplicateNames());
    }

    @GetMapping("/group-by-name")
    public ResponseEntity<?> groupByNames(){
        return ResponseEntity.ok(employeeService.groupByNames());
    }
    @GetMapping("/group-by-name-2")
    public ResponseEntity<?> groupByNames_2(){
        return ResponseEntity.ok(employeeService.groupByNames());
    }

    @GetMapping("/find-first-duplicate-employee-name")
    public ResponseEntity<?> findFirstDuplicateEmployeeName(){
        return ResponseEntity.ok(employeeService.findFirstDumplicateEmployeeName());
    }

    @GetMapping("/find-first-duplicate-employee-name-using-collection-frequency")
    public ResponseEntity<?> findFirstDuplicateEmployeeNameUsingCollectionFrequency(){
        return ResponseEntity.ok(employeeService.findFirstDumplicateEmployeeNameUsingCollectionFrequency());
    }
}
