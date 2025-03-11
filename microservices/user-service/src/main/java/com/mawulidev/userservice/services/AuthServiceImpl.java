package com.mawulidev.userservice.services;

import com.mawulidev.userservice.dtos.AuthRequest;
import com.mawulidev.userservice.models.User;
import com.mawulidev.userservice.repository.UserRepository;
import com.mawulidev.userservice.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String authenticate(AuthRequest authRequestDTO) {
        //authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDTO.getEmail(),
                        authRequestDTO.getPassword()
                )
        );

        Optional<User> user = userRepository.findUsersByEmail(authRequestDTO.getEmail());
        return user.map(value -> jwtService.generateToken(value.getEmail())).orElse(null);
    }
}
