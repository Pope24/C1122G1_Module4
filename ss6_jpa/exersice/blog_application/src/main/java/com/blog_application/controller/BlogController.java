package com.blog_application.controller;

import com.blog_application.model.Blog;
import com.blog_application.service.IBlogService;
import com.blog_application.service.ITypeBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ModelAndView showListBlog(@RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBlog");
        Sort sort = Sort.by("typeBlog").descending();
        pageable = PageRequest.of(page, 3, sort);
        modelAndView.addObject("blogList", blogService.findAll(pageable));
        modelAndView.addObject("typeBlogList", typeBlogService.findAll());
        modelAndView.addObject("pageCurrent", page);
        return modelAndView;
    }

    @GetMapping("/type-blog/{id}")
    public ModelAndView showBlogListByTypeBlog(@PathVariable int id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogList", blogService.findAllBlogByTypeBlog(id, pageable));
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

    @PostMapping("/create-blog/save")
    public String saveNewBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update-blog/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("formEditBlog");
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("typeBlog", typeBlogService.findAll());
        return modelAndView;
    }

    @PostMapping("update-blog/save")
    public String saveUpdateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlogbyId(@PathVariable int id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @PostMapping("/search-blog")
    public ModelAndView searchBlogByName(@RequestParam String search, @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("typeBlog").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogList", blogService.findBlogsByNTitle(search, pageable));
        return modelAndView;
    }
}
