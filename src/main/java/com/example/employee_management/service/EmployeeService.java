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

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setDepartment(updatedEmployee.getDepartment());

                return employee;
            }
        }
        return null;
    }

    public Employee getEmployeeById(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);

                return true;
            }
        }
        return false;
    }
}
