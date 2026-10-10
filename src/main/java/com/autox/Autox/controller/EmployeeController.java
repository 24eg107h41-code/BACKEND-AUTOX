package com.autox.Autox.controller;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autox.Autox.entity.Employee;
import com.autox.Autox.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee employee) {

        try {
            Employee savedEmployee = employeeService.registerEmployee(employee);
            return ResponseEntity.ok(savedEmployee);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody HashMap<String, String> loginData) {

    try {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Employee employee = employeeService.loginEmployee(email, password);

        return ResponseEntity.ok(employee);

    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}
