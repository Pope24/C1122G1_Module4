package com.blog_application.service.impl;

import com.blog_application.model.TypeBlog;
import com.blog_application.repository.ITypeBlogRepository;
import com.blog_application.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeBlogService implements ITypeBlogService {
    @Autowired
    private ITypeBlogRepository typeBlogRepository;

    @Override
    public Iterable<TypeBlog> findAll() {
        return typeBlogRepository.findAll();
    }
}
