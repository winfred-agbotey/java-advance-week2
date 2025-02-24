package com.mawulidev.blogservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog")
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Blog Service!";
    }
}
