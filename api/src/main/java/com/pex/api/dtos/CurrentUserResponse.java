package com.pex.api.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CurrentUserResponse {
    private UUID id;
    private String email;
    private CurrentUserDto user;

    public CurrentUserResponse(UUID id, String email, CurrentUserDto user) {
        this.id = id;
        this.email = email;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CurrentUserDto getUser() {
        return user;
    }

    public void setUser(CurrentUserDto user) {
        this.user = user;
    }
}
