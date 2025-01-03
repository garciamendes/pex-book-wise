package com.pex.api.entities;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "categories")
@Entity
public class Category {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String slug;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookCategories", joinColumns = @JoinColumn(name = "categoryId"), inverseJoinColumns = @JoinColumn(name = "bookId"))
    private List<Book> books;

    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        generateSlug();
    }

    @PreUpdate
    protected void onUpdate() {
        generateSlug();
    }

    private void generateSlug() {
        String normalized = Normalizer.normalize(title, Normalizer.Form.NFD);
        String withoutAccents = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        String alphanumeric = withoutAccents.replaceAll("[^a-zA-Z0-9\\s]", "");

        this.slug = alphanumeric.trim().toLowerCase().replaceAll("\\s+", "-");
    }

    public Category(UUID id, String title, String slug, List<Book> books, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.books = books;
        this.createdAt = createdAt;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
