package com.example.code_decode.domain.entity.postgres;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "ms_employee")
@Entity
public class EmployeeMasterEntity {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "ms_employee_sequence", sequenceName = "ms_employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ms_employee_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
