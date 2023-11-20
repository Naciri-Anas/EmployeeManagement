package com.employee.example.dao;

import com.employee.example.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {

}
