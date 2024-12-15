package com.pex.api_book_wise.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
  private UUID id;
  private String name;
  private Integer total_pages_readed;
  private Integer total_number_books_evaluated;
  private Integer total_author_readed;
  private List<BookDto> books;
  private BookDto currentReadingBook;
  private CategoryDto most_read_category;
  private LocalDateTime createdAt;
}
