package com.save_email_configuration.controller;

import com.save_email_configuration.model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping("")
    public String showFormUpdateEmailConfiguration(ModelMap model) {
        model.addAttribute("emailConfiguration", new EmailConfiguration());
        return "form";
    }
    @PostMapping("email-configuration")
    public String updateEmailConfiguration(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration, ModelMap model) {
        model.addAttribute("versionUpdateLatest", emailConfiguration);
        return "form";
    }
}
