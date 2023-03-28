package com.may_tinh_ca_nhan.controller;

import com.may_tinh_ca_nhan.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String showFormCalculator() {
        return "form";
    }

    @PostMapping("{operator}")
    public String calculate(@RequestParam double numberOne, @RequestParam double numberTwo, @PathVariable String operator, Model model) {
        double result = 0;
        try {
            result = calculatorService.calculate(numberOne, numberTwo, operator);
        } catch (ArithmeticException e) {
            model.addAttribute("messageError", "Can not divide with zero");
        }
        model.addAttribute("result", result);
        return "form";
    }
}
