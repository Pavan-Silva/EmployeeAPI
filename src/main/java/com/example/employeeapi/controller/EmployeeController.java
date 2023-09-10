package com.example.employeeapi.controller;

import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);
        return "Deleted employee - " + id;
    }
}