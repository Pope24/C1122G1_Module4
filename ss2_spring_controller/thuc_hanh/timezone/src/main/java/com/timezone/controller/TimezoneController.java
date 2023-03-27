package com.timezone.controller;

import com.timezone.service.ITimezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("")
public class TimezoneController {
    @Autowired
    private ITimezoneService timezoneService;
    @GetMapping("")
    public String showTimezoneDefault() {
        return "index";
    }
    @GetMapping("world-clock")
    public String showTimezoneCity(@RequestParam String city, Model model) {
        Date date = timezoneService.getTimezoneCity(city);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
