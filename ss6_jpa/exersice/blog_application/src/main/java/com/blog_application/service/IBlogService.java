package com.blog_application.service;

import com.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll(Pageable pageable);

    Page<Blog> findAllBlogByTypeBlog(int id, Pageable pageable);

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void remove(int id);
    Page<Blog> findBlogsByNTitle(String name, Pageable pageable);
}
