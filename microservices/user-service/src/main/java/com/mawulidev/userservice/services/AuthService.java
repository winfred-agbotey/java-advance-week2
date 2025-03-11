package com.mawulidev.userservice.services;

import com.mawulidev.userservice.dtos.AuthRequest;

public interface AuthService {
    String authenticate(AuthRequest authRequestDTO);
}
