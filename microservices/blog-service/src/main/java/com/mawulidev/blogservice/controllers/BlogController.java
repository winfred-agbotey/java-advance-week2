package com.mawulidev.blogservice.controllers;

import com.mawulidev.blogservice.dto.BlogDTO;
import com.mawulidev.blogservice.dto.ResponseHandler;
import com.mawulidev.blogservice.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAnyAuthority;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
@EnableMethodSecurity
public class BlogController {
    private final BlogService blogService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('SCOPE_read')")
    public ResponseEntity<Object> getAllBlog() {
        return ResponseHandler.successResponse(HttpStatus.OK, blogService.getAllBlog());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_read')")

    public ResponseEntity<Object> getBlog(@PathVariable("id") String id) {
        return ResponseHandler.successResponse(HttpStatus.OK, blogService.getBlog(id));
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority('SCOPE_write')")
    public ResponseEntity<Object> createBlog(@RequestBody BlogDTO blogDTO) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, blogService.createBlog(blogDTO));
    }
}
