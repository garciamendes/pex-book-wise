package com.pex.api_book_wise.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInDTO {
  private String search;
  private List<String> categories;
  private Integer page;
}
