package com.employee.example.service;

import com.employee.example.beans.Employee;
import com.employee.example.dao.EmployeeDao;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobKOctets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) {
        if(Objects.nonNull(employee)){
            employeeDao.save(employee);
        }


    }

    @Override
    public Employee getById(Long Id) {
        Employee employee  =null;
        if(Objects.nonNull(Id)){
            Optional<Employee> optionalEmployee =  employeeDao.findById(Id);

            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }else{
                throw new RuntimeException("Employee not found with the id :"+Id);
            }
        }
        return employee;


    }

    @Override
    public void deleteById(Long Id) {
    if(Objects.nonNull(Id)){
        employeeDao.deleteById(Id);

    }
    }
}
