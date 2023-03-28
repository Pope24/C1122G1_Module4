package com.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @GetMapping("")
    public String showFormCondiments() {
        return "form";
    }
    @PostMapping("save")
    public String showCondimentsChoosed(@RequestParam(required = false) String[] condiments, Model model) {
        model.addAttribute("condiments",condiments);
        return "form";
    }
}
