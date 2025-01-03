package com.pex.api.dtos;

import java.util.UUID;

public class CategoryDto {
    private UUID id;
    private String title;
    private String slug;

    public CategoryDto(UUID id, String title, String slug) {
        this.id = id;
        this.title = title;
        this.slug = slug;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
