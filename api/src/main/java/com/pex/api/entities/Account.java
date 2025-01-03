package com.pex.api.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String avatar;

    private Integer totalPagesReaded = 0;

    private Integer totalNumberBooksEvaluated = 0;

    private Integer totalAuthorReaded = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userBooks", joinColumns = @JoinColumn(name = "accountId"), inverseJoinColumns = @JoinColumn(name = "bookId"))
    private List<Book> books;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "userCategoryCounts", joinColumns = @JoinColumn(name = "accountId"))
    @MapKeyJoinColumn(name = "categoryId")
    @Column(name = "readCount")
    private Map<Category, Integer> categoryReadCounts = new HashMap<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mostReadCategoryId")
    private Category mostReadCategory;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currentReadingBookId")
    private Book currentReadingBook;

    @OneToOne(mappedBy = "account", fetch = FetchType.EAGER)
    @JsonBackReference
    private Auth auth;

    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    public Account() {

    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Account(UUID id, String name, String avatar, Integer totalPagesReaded, Integer totalNumberBooksEvaluated, Integer totalAuthorReaded, List<Book> books, Map<Category, Integer> categoryReadCounts, Category mostReadCategory, Book currentReadingBook, Auth auth, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.totalPagesReaded = totalPagesReaded;
        this.totalNumberBooksEvaluated = totalNumberBooksEvaluated;
        this.totalAuthorReaded = totalAuthorReaded;
        this.books = books;
        this.categoryReadCounts = categoryReadCounts;
        this.mostReadCategory = mostReadCategory;
        this.currentReadingBook = currentReadingBook;
        this.auth = auth;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<Category, Integer> getCategoryReadCounts() {
        return categoryReadCounts;
    }

    public void setCategoryReadCounts(Map<Category, Integer> categoryReadCounts) {
        this.categoryReadCounts = categoryReadCounts;
    }

    public Category getMostReadCategory() {
        return mostReadCategory;
    }

    public void setMostReadCategory(Category mostReadCategory) {
        this.mostReadCategory = mostReadCategory;
    }

    public Book getCurrentReadingBook() {
        return currentReadingBook;
    }

    public void setCurrentReadingBook(Book currentReadingBook) {
        this.currentReadingBook = currentReadingBook;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
