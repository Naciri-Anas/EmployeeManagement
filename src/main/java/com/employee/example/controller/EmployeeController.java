package com.employee.example.controller;

import com.employee.example.beans.Employee;
import com.employee.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "addEmployee";
    }
    @PostMapping("/save")
    public String SaveEmployee (@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";


    }
    @GetMapping("updateform/{Id}")
    public String UpdateFrom(@PathVariable(value = "Id") Long Id,Model model ){
        Employee employee  = employeeService.getById(Id);
        model.addAttribute("employee",employee);
        return "update";

    }
    @DeleteMapping("/delete/{Id}")
    public String deleteById(@PathVariable(value = "Id") Long Id){
        employeeService.deleteById(Id);
        return "redirect:/";
    }
}
