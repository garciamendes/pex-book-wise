package com.pex.api_book_wise.dtos;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {
  private List<T> result;
  private int page;
  private long totalElements;
  private int totalPages;
  private Integer next;
  private Integer previous;

  public PaginationResponse(Page<T> props, Integer next, Integer previous) {
    this.page = props.getNumber();
    this.totalElements = props.getTotalElements();
    this.totalPages = props.getTotalPages();
    this.next = next;
    this.previous = previous;
    this.result = props.getContent();
  }
}
