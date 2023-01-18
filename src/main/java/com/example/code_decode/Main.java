package com.example.code_decode;

import com.example.code_decode.compartor.AgeComparator;
import com.example.code_decode.domain.model.Address;
import com.example.code_decode.domain.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("tom",29,new Address("street1",120498));
        Employee employee1 = new Employee("hardy",32,new Address("street2",128498));
        Employee employee2 = new Employee("peter",20,new Address("las vegas",120478));
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);

        System.out.println("Unsorted Employee List "+employeeList);
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(employeeList, ageComparator);
        System.out.println("Sorted Employee List "+employeeList);
    }
}
