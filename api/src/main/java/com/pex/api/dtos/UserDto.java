package com.pex.api.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserDto {
    private UUID id;
    private String name;
    private Integer totalPagesReaded;
    private Integer totalNumberBooksEvaluated;
    private Integer totalAuthorReaded;
    private List<BookDto> books;
    private BookDto currentReadingBook;
    private CategoryDto mostReadCategory;
    private LocalDateTime createdAt;

    public UserDto(UUID id, String name, Integer totalPagesReaded, Integer totalNumberBooksEvaluated, Integer totalAuthorReaded, List<BookDto> books, BookDto currentReadingBook, CategoryDto mostReadCategory, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.totalPagesReaded = totalPagesReaded;
        this.totalNumberBooksEvaluated = totalNumberBooksEvaluated;
        this.totalAuthorReaded = totalAuthorReaded;
        this.books = books;
        this.currentReadingBook = currentReadingBook;
        this.mostReadCategory = mostReadCategory;
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

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public BookDto getCurrentReadingBook() {
        return currentReadingBook;
    }

    public void setCurrentReadingBook(BookDto currentReadingBook) {
        this.currentReadingBook = currentReadingBook;
    }

    public CategoryDto getMostReadCategory() {
        return mostReadCategory;
    }

    public void setMostReadCategory(CategoryDto mostReadCategory) {
        this.mostReadCategory = mostReadCategory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
