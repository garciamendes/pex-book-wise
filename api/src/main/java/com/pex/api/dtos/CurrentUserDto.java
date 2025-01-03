package com.pex.api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CurrentUserDto {
    private UUID id;
    private String name;
    private Integer totalPagesReaded;
    private Integer totalNumberBooksEvaluated;
    private Integer totalAuthorReaded;
    private LocalDateTime createdAt;

    public CurrentUserDto(UUID id, String name, Integer totalPagesReaded, Integer totalNumberBooksEvaluated, Integer totalAuthorReaded, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.totalPagesReaded = totalPagesReaded;
        this.totalNumberBooksEvaluated = totalNumberBooksEvaluated;
        this.totalAuthorReaded = totalAuthorReaded;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPagesReaded() {
        return totalPagesReaded;
    }

    public void setTotalPagesReaded(Integer totalPagesReaded) {
        this.totalPagesReaded = totalPagesReaded;
    }

    public Integer getTotalNumberBooksEvaluated() {
        return totalNumberBooksEvaluated;
    }

    public void setTotalNumberBooksEvaluated(Integer totalNumberBooksEvaluated) {
        this.totalNumberBooksEvaluated = totalNumberBooksEvaluated;
    }

    public Integer getTotalAuthorReaded() {
        return totalAuthorReaded;
    }

    public void setTotalAuthorReaded(Integer totalAuthorReaded) {
        this.totalAuthorReaded = totalAuthorReaded;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}