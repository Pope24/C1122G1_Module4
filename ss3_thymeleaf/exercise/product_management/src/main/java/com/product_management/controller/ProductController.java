package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "listProduct";
    }

    @GetMapping("add-product")
    public String showFormAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formCreate";
    }

    @PostMapping("add-product/save")
    public String saveProduct(@ModelAttribute Product product) {
        int id = (int) (Math.random() * 10000);
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "formEdit";
    }

    @PostMapping("{id}/update")
    public String updateProduct(@ModelAttribute Product product, @PathVariable int id) {
        productService.updateProduct(id, product);
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String showDetailProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "viewProduct";
    }

    @PostMapping("search-product")
    public String searchProductByName(@RequestParam String search, Model model) {
        model.addAttribute("product", productService.searchProductByName(search));
        return "viewProduct";
    }
}
