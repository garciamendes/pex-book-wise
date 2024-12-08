package com.pex.api_book_wise.domains.category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.pex.api_book_wise.domains.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "category")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  @GeneratedValue
  private UUID id;

  private String title;

  @ManyToMany
  @JoinTable(
    name = "book_categories",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id")
  )
  private List<Book> books;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
