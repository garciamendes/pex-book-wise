package com.pex.api_book_wise.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
  private UUID id;
  private String title;
}
