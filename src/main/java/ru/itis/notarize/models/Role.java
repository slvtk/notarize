package ru.itis.notarize.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_CLIENT, ROLE_NOTARY;

    @Override
    public String getAuthority() {
        return name();
    }
}
