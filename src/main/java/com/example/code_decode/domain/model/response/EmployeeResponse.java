package com.example.code_decode.domain.model.response;

import com.example.code_decode.domain.entity.postgres.EmployeeMasterEntity;
import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private int age;

    public EmployeeResponse(EmployeeMasterEntity employeeMasterEntity) {
        this.id = employeeMasterEntity.getId();
        this.name = employeeMasterEntity.getName();
        this.age = employeeMasterEntity.getAge();
    }
}
