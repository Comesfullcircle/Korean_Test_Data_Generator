package com.seol.koreantestdatagenerator.dto.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public record GithubUser(
        String id,
        String name,
        String email
) implements OAuth2User {

    public static GithubUser from(Map<String, Object> attributes) {
        return new GithubUser(
                String.valueOf(attributes.get("login")),
                String.valueOf(attributes.get("name")),   //nullable
                String.valueOf(attributes.get("email"))  //nullable
        );
    }

    @Override public Map<String, Object> getAttributes() {return Map.of();}
    @Override public Collection<? extends GrantedAuthority> getAuthorities() {return List.of();}
    @Override public String getName() {return name.equals("null") ? id : name;}
}
