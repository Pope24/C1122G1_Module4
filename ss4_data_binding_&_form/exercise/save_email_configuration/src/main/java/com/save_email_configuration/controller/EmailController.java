package com.save_email_configuration.controller;

import com.save_email_configuration.model.EmailConfiguration;
import com.save_email_configuration.service.impl.EmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private EmailConfigurationService emailConfigurationService;

    @GetMapping("")
    public String showFormUpdateEmailConfiguration(ModelMap model) {
        model.addAttribute("emailConfiguration", new EmailConfiguration());
        return "formConfiguration";
    }

    @PostMapping("email-configuration")
    public String updateEmailConfiguration(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration, ModelMap model) {
        emailConfigurationService.saveEmailConfiguration(emailConfiguration);
        model.addAttribute("versionUpdateLatest", emailConfiguration);
        return "formConfiguration";
    }

    @GetMapping("version-current")
    public String getEmailConfigurationCurrentVersion(Model model) {
        EmailConfiguration emailConfigurationCurrent = emailConfigurationService.getVersionEmailConfiguration();
        model.addAttribute("versionUpdateLatest", emailConfigurationCurrent);
        return "versionCurrent";
    }
}
