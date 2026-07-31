package com.example.employee_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
}

