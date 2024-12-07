package com.pex.api_book_wise.domains.book_rating;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.domains.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "book_rating")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRating {
  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id", nullable = false)
  private Book book;

  private Integer rating; // Nota do livro (por exemplo, de 1 a 5)

  private String comment;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
