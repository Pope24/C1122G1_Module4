package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("listProduct");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }
    @GetMapping("create-product")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "formCreate";
    }
    @PostMapping("create-product/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("formEdit");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("edit-product/save")
    public String editProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/product";
    }
}
