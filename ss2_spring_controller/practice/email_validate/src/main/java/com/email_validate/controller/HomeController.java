package com.email_validate.controller;

import com.email_validate.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("/")
    public String showFormEmailValidate() {
        return "form";
    }
    @PostMapping("validate")
    public String checkEmailValidate(@RequestParam String email, Model model) {
        if (emailService.checkEmail(email) == true) {
            System.out.println("true");
            model.addAttribute("statusTrue", "Email nguoi dung hop le");
        }
        else {
            System.out.println("false");
            model.addAttribute("statusFalse", "Email nguoi dung khong hop le !!");
        }
        return "form";
    }
}
