package com.blog_application.controller;

import com.blog_application.model.Blog;
import com.blog_application.service.IBlogService;
import com.blog_application.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITypeBlogService typeBlogService;

    @GetMapping("")
    public ModelAndView showListBlog() {
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogList", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailBlog(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detailBlog");
        modelAndView.addObject("blog", blogService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public String showFormCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        System.out.println(typeBlogService.findAll());
        model.addAttribute("typeBlog", typeBlogService.findAll());
        return "formCreateBlog";
    }

    @GetMapping("/update-blog/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("formEditBlog");
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("typeBlog", typeBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlogbyId(@PathVariable int id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @PostMapping("/create-blog/save")
    public String saveNewBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @PostMapping("update-blog/save")
    public String saveUpdateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }
}
