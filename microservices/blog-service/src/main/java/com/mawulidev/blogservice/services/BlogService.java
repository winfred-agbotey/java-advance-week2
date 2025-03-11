package com.mawulidev.blogservice.services;

import com.mawulidev.blogservice.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    String createBlog(BlogDTO blogDTO);
    List<BlogDTO> getAllBlog();
    BlogDTO getBlog(String id);
}
