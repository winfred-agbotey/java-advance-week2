package com.mawulidev.userservice.models.converter;

import com.mawulidev.userservice.models.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class UserInfoUserDetails implements UserDetails {
    private final String username;
    private final String password;
    private final String role;

    public UserInfoUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole().name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));

    }


    @Override
    public @NotNull String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}