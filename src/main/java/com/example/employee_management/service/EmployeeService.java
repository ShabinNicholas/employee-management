package com.example.employee_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.exception.EmployeeNotFoundException;
import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + " not found"));

        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setDepartment(updatedEmployee.getDepartment());

        return employeeRepository.save(employee);

    }

    public Employee getEmployeeById(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with: " + id);
    }

    public boolean deleteEmployee(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);

                return true;
            }
        }
        throw new EmployeeNotFoundException("Employee with id: " + id + "not found");
    }
}
