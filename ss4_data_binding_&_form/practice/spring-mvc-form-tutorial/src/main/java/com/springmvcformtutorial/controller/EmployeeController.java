package com.springmvcformtutorial.controller;

import com.springmvcformtutorial.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @GetMapping("showForm")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping("addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("employee", employee);
        return "employee/info";
    }

}
