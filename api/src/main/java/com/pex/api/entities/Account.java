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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
