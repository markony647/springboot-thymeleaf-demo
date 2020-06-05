package com.marchenko.springboot.thymeleafdemo.controller;

import com.marchenko.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        this.employees = asList(
                new Employee(1, "Leslie", "Andrewes", "andrew@gmail.com"),
                new Employee(1, "Emma", "Sam", "emma@gmail.com"),
                new Employee(1, "Joshua", "Sean", "john@gmail.com")
        );
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}
