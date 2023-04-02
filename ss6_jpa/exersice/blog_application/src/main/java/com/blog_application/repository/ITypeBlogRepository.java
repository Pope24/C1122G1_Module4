package com.blog_application.repository;

import com.blog_application.model.TypeBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeBlogRepository extends JpaRepository<TypeBlog, Integer> {
}
