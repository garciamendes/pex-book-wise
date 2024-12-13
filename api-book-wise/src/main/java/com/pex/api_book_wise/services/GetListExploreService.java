package com.pex.api_book_wise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.dtos.BookFiltersDTO;
import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.repositories.BookRepository;
import com.pex.api_book_wise.repositories.specification.BookSpecification;

@Service
public class GetListExploreService {
  @Autowired
  private BookRepository bookRepository;

  public Page<Book> getList(BookInDTO bookInDto) {
    BookFiltersDTO filters = BookFiltersDTO.builder()
        .search(bookInDto.getSearch())
        .categories(bookInDto.getCategories())
        .build();

    PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
    Specification<Book> specification = BookSpecification.getSpecification(filters);
    Page<Book> books = this.bookRepository.findAll(specification, pageRequest);

    return books;
  }
}
