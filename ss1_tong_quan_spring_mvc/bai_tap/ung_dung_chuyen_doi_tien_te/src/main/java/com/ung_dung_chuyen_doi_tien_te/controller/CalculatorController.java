package com.ung_dung_chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {
    @GetMapping("calculate")
    public String showFormCalculator() {
        return "form";
    }
    @PostMapping("calculate/result")
    public String showResultCalculator(Model model, @RequestParam(name = "usd") String usd) {
        double result = Double.parseDouble(usd) * 23000;
        model.addAttribute("result", result);
        return "result";
    }
}
