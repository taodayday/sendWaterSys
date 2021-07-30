package com.ttt.water.controller;

import com.ttt.water.entities.Salary;
import com.ttt.water.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/salaryList")
    public String listSalary(Model model){
        List<Salary> list =salaryService.listSalary();
        model.addAttribute("salaryList",list);
        return "/salaryList";
    }
}
