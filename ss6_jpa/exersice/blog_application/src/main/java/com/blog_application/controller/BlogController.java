package com.blog_application.controller;

import com.blog_application.model.Blog;
import com.blog_application.service.IBlogService;
import com.blog_application.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin({"*", "http://localhost:63343"})
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITypeBlogService typeBlogService;

    @GetMapping("")
    public ResponseEntity<ModelAndView> showListBlog(@RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBlog");
        Sort sort = Sort.by("typeBlog").descending();
        pageable = PageRequest.of(page, 3, sort);
        modelAndView.addObject("blogList", blogService.findAll(pageable));
        modelAndView.addObject("typeBlogList", typeBlogService.findAll());
        modelAndView.addObject("pageCurrent", page);
        return new ResponseEntity<>(modelAndView, HttpStatus.OK);
    }

    @GetMapping("/type-blog/{id}")
    public ResponseEntity<ModelAndView> showBlogListByTypeBlog(@PathVariable int id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogList", blogService.findAllBlogByTypeBlog(id, pageable));
        return new ResponseEntity<>(modelAndView, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ModelAndView> showDetailBlog(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detailBlog");
        modelAndView.addObject("blog", blogService.findById(id).get());
        return new ResponseEntity<>(modelAndView, HttpStatus.OK);
    }

    @GetMapping("/create-blog")
    public ResponseEntity showFormCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        System.out.println(typeBlogService.findAll());
        model.addAttribute("typeBlog", typeBlogService.findAll());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-blog/save")
    public String saveNewBlog(@ModelAttribute Blog blog) {


        blogService.save(blog);
        new ResponseEntity<>(HttpStatus.CREATED);
        return "redirect:/blog";
    }

    @GetMapping("/update-blog/{id}")
    public ResponseEntity<ModelAndView> showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("formEditBlog");
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("typeBlog", typeBlogService.findAll());
        return new ResponseEntity<>(modelAndView, HttpStatus.OK);
    }

    @PostMapping("/update-blog/save")
    public String saveUpdateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        new ResponseEntity<>(HttpStatus.OK);
        return "redirect:/blog";
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlogbyId(@PathVariable int id) {
        blogService.remove(id);
        new ResponseEntity<>(HttpStatus.OK);
        return "redirect:/blog";
    }

    @PostMapping("/search-blog")
    public ResponseEntity<ModelAndView> searchBlogByName(@RequestParam String search, @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("typeBlog").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogList", blogService.findBlogsByNTitle(search, pageable));
        return new ResponseEntity<>(modelAndView, HttpStatus.OK);
    }
}
