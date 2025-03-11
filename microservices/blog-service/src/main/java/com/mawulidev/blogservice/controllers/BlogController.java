package com.mawulidev.blogservice.controllers;

import com.mawulidev.blogservice.dto.BlogDTO;
import com.mawulidev.blogservice.dto.ResponseHandler;
import com.mawulidev.blogservice.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("")
    public ResponseEntity<Object> getAllBlog() {
        return ResponseHandler.successResponse(HttpStatus.OK, blogService.getAllBlog());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBlog(@PathVariable("id") String id) {
        return ResponseHandler.successResponse(HttpStatus.OK, blogService.getBlog(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createBlog(@RequestBody BlogDTO blogDTO) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, blogService.createBlog(blogDTO));
    }
}
