package com.mawulidev.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Welcome {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to UserService";
    }
}
