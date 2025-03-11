package com.mawulidev.userservice.controller;

import com.mawulidev.userservice.dtos.AuthRequest;
import com.mawulidev.userservice.dtos.ResponseHandler;
import com.mawulidev.userservice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseHandler.successResponse(HttpStatus.OK,authService.authenticate(authRequest));
    }
}
