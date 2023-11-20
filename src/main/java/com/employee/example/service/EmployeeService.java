package com.employee.example.service;

import com.employee.example.beans.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee getById(Long Id);
    void deleteById(Long Id);




}
