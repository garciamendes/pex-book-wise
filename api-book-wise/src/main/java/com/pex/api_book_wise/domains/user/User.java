package com.pex.api_book_wise.domains.user;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.book.Book;

import com.pex.api_book_wise.domains.category.Category;
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

@Table(name = "users")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = true)
  private String name;

  @Column(nullable = true)
  private String avatar;

  private Integer total_pages_readed = 0;

  private Integer total_number_books_evaluated = 0;

  private Integer total_author_readed = 0;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_books", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
  private List<Book> books;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "user_category_counts", joinColumns = @JoinColumn(name = "user_id"))
  @MapKeyJoinColumn(name = "category_id")
  @Column(name = "read_count")
  private Map<Category, Integer> categoryReadCounts = new HashMap<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "most_read_category_id")
  private Category most_read_category;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "current_reading_book_id")
  private Book currentReadingBook;

  @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
  @JsonBackReference
  private Auth auth;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
