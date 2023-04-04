package com.validation_form_sign_up.controller;

import com.validation_form_sign_up.model.User;
import com.validation_form_sign_up.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView showFormUserAccount() {
        ModelAndView modelAndView = new ModelAndView("formUserAccount");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validate")
    public String submitFormUserAccount(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formUserAccount";
        }
        return "resultValidation";
    }
}
