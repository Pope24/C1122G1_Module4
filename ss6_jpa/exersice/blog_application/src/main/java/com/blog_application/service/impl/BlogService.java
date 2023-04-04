package com.blog_application.service.impl;

import com.blog_application.model.Blog;
import com.blog_application.model.TypeBlog;
import com.blog_application.repository.IBlogRepository;
import com.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByTypeBlog(int id, Pageable pageable) {
        return blogRepository.findAllByTypeBlog_Id(id, pageable);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogsByNTitle(String name, Pageable pageable) {
        return blogRepository.findBlogsByTitleContaining(name, pageable);
    }

}
