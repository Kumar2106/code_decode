package com.example.code_decode.service.impl;

import com.example.code_decode.domain.entity.postgres.EmployeeMasterEntity;
import com.example.code_decode.domain.model.response.EmployeeResponse;
import com.example.code_decode.repository.EmployeeRepository;
import com.example.code_decode.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
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

    @Override
    public List<String> getNames() {
        log.info("EmployeeServiceImpl:getNames: Fetching names of all the employee from the db");
        return employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName()).toList();
    }

    @Override
    public Set<String> getNonDuplicateNames() {
        log.info("EmployeeServiceImpl:getNonDuplicateNames: Fetching all the non duplicate names of the employee from the db");
        return employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDuplicateNames() {
        log.info("EmployeeServiceImpl:getUniqueNames: Fetching all the unique names of the employee from the db");
        Set<String> uniqueName = new HashSet<>();
        return employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName())
                .filter(s -> !uniqueName.add(s)).collect(Collectors.toSet());
    }

    @Override
    public Map<String, Long> groupByNames() {
        log.info("EmployeeServiceImpl:groupByNames: Grouping on the basis of name of the employee");
        return employeeRepository.findAll().stream().collect(Collectors
                .groupingBy(employeeMasterEntity -> employeeMasterEntity.getName(), Collectors.counting()));
    }

    @Override
    public Map<String, Long> groupByNames_2() {
        log.info("EmployeeServiceImpl:groupByNames_2: Grouping on the basis of name of the employee");
        List<String> names = employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName()).toList();
        return names.stream().collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public String findFirstDumplicateEmployeeName() {
        log.info("EmployeeServiceImpl:groupByNames_2: Finding first duplicate employee name");
        List<String> names = employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName()).toList();
        Map<String, Long> employeeNameMap = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return employeeNameMap.entrySet().stream().filter(entry -> entry.getValue() > 1l).findFirst().get().getKey();
    }

    @Override
    public String findFirstDumplicateEmployeeNameUsingCollectionFrequency() {
        log.info("EmployeeServiceImpl:groupByNames_2: Finding first duplicate employee name using Collections.frequency()");
        List<String> names = employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getName()).toList();
        return names.stream().filter(name -> Collections.frequency(names, name) > 1).findFirst().get();
    }

    @Override
    public String findEmployeeById(Long id) {
        log.info("EmployeeServiceImpl:findEmployeeById: Finding employee in ms_employee with id {} ", id);
        String name = null;
        name = employeeRepository.findById(id).orElse(getDefaultEmployee()).getName();
        name = Optional.ofNullable(employeeRepository.findById(id).get().getName()).orElseGet(()-> getDefaultEmployee().getName());
        return name;
    }

    @Override
    public List<?> ageInDescendingOrder() {
        log.info("EmployeeServiceImpl:ageInDescendingOrder: Creating List of ages of the employee in descending order");
        return employeeRepository.findAll().stream().map(employeeMasterEntity -> employeeMasterEntity.getAge()).filter(Objects::nonNull).sorted(Collections.reverseOrder()).limit(3).toList();
    }


    private static EmployeeMasterEntity getDefaultEmployee() {
        EmployeeMasterEntity employeeMasterEntity = new EmployeeMasterEntity();
        employeeMasterEntity.setAge(20);
        employeeMasterEntity.setId(1l);
        employeeMasterEntity.setName("Kumar Aditya");
        return employeeMasterEntity;
    }
}
