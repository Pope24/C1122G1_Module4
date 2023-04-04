package com.validation_form_input.controller;

import com.validation_form_input.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("")
    public ModelAndView showFormUserInput() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView validateUser(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("form");
        }
        return new ModelAndView("success");
    }
}
