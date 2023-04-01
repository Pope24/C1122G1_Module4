package com.basic_wb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/greeting-spring-boot")
    public ModelAndView showGreetingPage() {
        return new ModelAndView("/greeting");
    }
}
