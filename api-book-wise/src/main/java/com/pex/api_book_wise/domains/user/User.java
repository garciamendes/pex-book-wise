package com.pex.api_book_wise.domains.user;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Locale.Category;

import com.pex.api_book_wise.domains.book.Book;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private String avatar;

  private Integer total_pages_readed;

  private Integer total_number_books_evaluated;

  private Integer total_author_readed;

  @ManyToMany
  @JoinTable(name = "user_books", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
  private List<Book> books;

  @ElementCollection
  @CollectionTable(name = "user_category_counts", joinColumns = @JoinColumn(name = "user_id"))
  @MapKeyJoinColumn(name = "category_id")
  @Column(name = "read_count")
  private Map<Category, Integer> categoryReadCounts = new HashMap<>();

  @ManyToOne
  @JoinColumn(name = "most_read_category_id")
  private Category most_read_category;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
