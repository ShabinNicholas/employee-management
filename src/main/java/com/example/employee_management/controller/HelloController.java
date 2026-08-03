package com.example.employee_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;

@RestController
public class HelloController {

    private final EmployeeService employeeService;

    public HelloController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // READ
    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // DELETE
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return "Employee deleted Successfully";
        } else {
            return "Employee not found";
        }
    }
    // CRUD

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}