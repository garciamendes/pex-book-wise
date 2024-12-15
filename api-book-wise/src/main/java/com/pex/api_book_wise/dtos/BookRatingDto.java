package com.pex.api_book_wise.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRatingDto {
  private UUID id;
  private BookDto book;
  private Integer rating;
  private String comment;
  private LocalDateTime createdAt;
}
