package com.ung_dung_chuyen_doi_tien_te.controller;

import com.ung_dung_chuyen_doi_tien_te.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @GetMapping("calculate")
    public String showFormCalculator() {
        return "form";
    }
    @PostMapping("calculate/result")
    public String showResultCalculator(Model model, @RequestParam(name = "usd") double usd) {
        double result = calculatorService.convertUSD(usd);
        model.addAttribute("result", result);
        return "result";
    }
}
