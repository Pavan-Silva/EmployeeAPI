package com.example.employeeapi.dao;

import com.example.employeeapi.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
