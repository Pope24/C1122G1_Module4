package com.blog_application.service;

import com.blog_application.model.TypeBlog;

public interface ITypeBlogService {
    Iterable<TypeBlog> findAll();
}
