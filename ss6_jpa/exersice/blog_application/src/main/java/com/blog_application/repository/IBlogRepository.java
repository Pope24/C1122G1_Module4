package com.blog_application.repository;

import com.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTypeBlog_Id(int id, Pageable pageable);
    Page<Blog> findBlogsByTitleContaining(String name, Pageable pageable);
}
