package com.autox.Autox.service;

import org.springframework.stereotype.Service;

import com.autox.Autox.entity.Employee;
import com.autox.Autox.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {

        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        return employeeRepository.save(employee);
    }
    public Employee loginEmployee(String email, String password) {

    Employee employee = employeeRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Email not found"));

    if (!employee.getPassword().equals(password)) {
        throw new RuntimeException("Invalid password");
    }

    return employee;
}
}