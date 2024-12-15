package com.pex.api_book_wise.domains.book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.pex.api_book_wise.domains.category.Category;
import com.pex.api_book_wise.domains.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "books")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  @Id
  @GeneratedValue
  private UUID id;

  private String title;

  private String description;

  private String thumbnail;

  private String author;

  private Integer total_pages;

  @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
  private List<User> users;

  @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
  private List<Category> categories;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
