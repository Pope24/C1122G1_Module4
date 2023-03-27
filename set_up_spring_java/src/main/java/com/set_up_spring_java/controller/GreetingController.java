package com.set_up_spring_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting() {
        return "/greeting";
    }
}
