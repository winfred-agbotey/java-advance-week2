package com.mawulidev.advancesecurity.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    Map<String, AppUser> users = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }

    @PostConstruct
    private void createHardcodedUsers() {
        var mawuli = AppUser.builder()
                .username("mawuli")
                .password(passwordEncoder.encode("mawuli"))
                .authorities(List.of(new SimpleGrantedAuthority("read")))
                .build();

        var kobby = AppUser.builder()
                .username("kobby")
                .password(passwordEncoder.encode("kobby"))
                .authorities(List.of(new SimpleGrantedAuthority("read")))
                .build();

        createUser(mawuli);
        createUser(kobby);
    }

    OAuth2UserService<OidcUserRequest, OidcUser> oidcLoginHandler() {
        return userRequest -> {
            LoginProvider provider = getProvider(userRequest);
            OidcUserService delegate = new OidcUserService();

            OidcUser oidcUser = delegate.loadUser(userRequest);
            return AppUser.builder()
                    .username(oidcUser.getEmail())
                    .name(oidcUser.getFullName())
                    .email(oidcUser.getEmail())
                    .userId(oidcUser.getName())
                    .imageUrl(oidcUser.getAttribute("picture"))
                    .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                    .attributes(oidcUser.getAttributes())
                    .authorities(oidcUser.getAuthorities())
                    .build();
        };
    }

    OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2LoginHandler() {
        return userRequest -> {
            LoginProvider provider = getProvider(userRequest);
            DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
            OAuth2User oAuth2User = delegate.loadUser(userRequest);
            return AppUser
                    .builder()
                    .provider(provider)
                    .username(oAuth2User.getAttribute("login"))
                    .name(oAuth2User.getAttribute("login"))
                    .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                    .userId(oAuth2User.getName())
                    .imageUrl(oAuth2User.getAttribute("avatar_url"))
                    .attributes(oAuth2User.getAttributes())
                    .authorities(oAuth2User.getAuthorities())
                    .build();
        };
    }

    private static LoginProvider getProvider(OAuth2UserRequest userRequest) {
        return LoginProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
    }

    private void createUser(AppUser user) {
        users.putIfAbsent(user.getUsername(), user);
    }
}
