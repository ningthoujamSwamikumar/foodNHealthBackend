package com.burnsena.foodNHealth.services;

import com.burnsena.foodNHealth.entities.Blog;
import com.burnsena.foodNHealth.repositories.BlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRespository blogRespository;

    public List<Blog> getAllBlogs(){
        return blogRespository.findAll();
    }

    public Blog getBlogById(Long blogId) {
        return blogRespository.findById(blogId).orElseThrow();
    }

    public Blog saveBlog(Blog blog) {
        return blogRespository.save(blog);
    }

    public Blog editBlog(Blog blog) {
        if(blog.getId() == null) throw new IllegalArgumentException("id is null");
        return blogRespository.save(blog);
    }

    public void deleteBlog(Long blogId) {
        blogRespository.deleteById(blogId);
    }
}
