package com.example.code_decode.repository;

import com.example.code_decode.domain.entity.postgres.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMasterEntity,Long> {
}
