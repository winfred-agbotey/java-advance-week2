package com.mawulidev.blogservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.blogservice.dto.BlogDTO;
import com.mawulidev.blogservice.exceptions.EntityNotFoundException;
import com.mawulidev.blogservice.models.Blog;
import com.mawulidev.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final ObjectMapper mapper;

    @Override
    public String createBlog(BlogDTO blogDTO) {
        Blog blog = mapper.convertValue(blogDTO, Blog.class);
        blogRepository.save(blog);
        return "BLOG SUCCESSFULLY CREATED";
    }

    @Override
    public List<BlogDTO> getAllBlog() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream().map(blog -> mapper.convertValue(blog, BlogDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BlogDTO getBlog(String id) {
        Optional<Blog> blog = blogRepository.findById(UUID.fromString(id));
        if (blog.isEmpty()) {
            throw new EntityNotFoundException("Blog not found");
        }
        return mapper.convertValue(blog, BlogDTO.class);
    }
}
