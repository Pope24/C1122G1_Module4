package com.blog_application.service;

import com.blog_application.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void remove(int id);
}
