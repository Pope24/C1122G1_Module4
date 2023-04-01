package com.customer_management.controller;

import com.customer_management.model.Customer;
import com.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false) boolean statusAdd) {
        model.addAttribute("customerList", customerService.findAll());
        if (statusAdd == true) {
            model.addAttribute("messageSuccess", "Them moi thanh cong.");
        }
        return "listCustomer";
    }
    @GetMapping("create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("formCreate");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("create-customer/save")
    public String saveNewCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer?statusAdd=true";
    }
    @GetMapping("edit-customer/{id}")
    public ModelAndView showFormEditCustomer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("formEdit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("edit-customer/save")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer?statusAdd=true";
    }
    @GetMapping("delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
}
