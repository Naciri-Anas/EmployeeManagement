package com.employee.example.controller;

import com.employee.example.beans.Employee;
import com.employee.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allemplist",employeeService.getAllEmployee());
        return "index";

    }
    @GetMapping("/add")
    public String AddNewEmployee(Model model){
        Employee employee =  new Employee();
        model.addAttribute("employee",employee);
        return "employee";
    }

}
