package com.burnsena.foodNHealth.controllers;

import com.burnsena.foodNHealth.entities.Blog;
import com.burnsena.foodNHealth.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/{blogId}")
    public Blog getBlog(@PathVariable Long blogId){
        return blogService.getBlogById(blogId);
    }

    @PostMapping
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @PutMapping
    public Blog editBlog(@RequestBody Blog blog){
        return blogService.editBlog(blog);
    }

    @DeleteMapping("/{blogId}")
    public void deleteBlog(@PathVariable Long blogId){
        blogService.deleteBlog(blogId);
    }

}
