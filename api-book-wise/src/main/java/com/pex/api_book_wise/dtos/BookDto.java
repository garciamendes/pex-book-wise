package com.pex.api_book_wise.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
  private UUID id;
  private String title;
  private String description;
  private String thumbnail;
  private String author;
  private Integer total_pages;
  private List<CategoryDto> categories;
  private LocalDateTime createdAt;
}
