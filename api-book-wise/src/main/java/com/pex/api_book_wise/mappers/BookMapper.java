package com.pex.api_book_wise.mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.dtos.BookDto;

public class BookMapper {

  public BookDto convertBookToDto(Book book) {

    if (book == null) {
      return null;
    }

    CategoryMapper categoryMapper = new CategoryMapper();
    return new BookDto(
        book.getId(),
        book.getTitle(),
        book.getDescription(),
        book.getThumbnail(),
        book.getAuthor(),
        book.getTotal_pages(),
        categoryMapper.convertCategoriesToDto(book.getCategories()),
        book.getCreatedAt());
  }

  public List<BookDto> convertBooksToDto(List<Book> books) {
    if (books == null) {
      return Collections.emptyList();
    }

    CategoryMapper categoryMapper = new CategoryMapper();
    return books.stream()
        .map(book -> new BookDto(
            book.getId(),
            book.getTitle(),
            book.getDescription(),
            book.getThumbnail(),
            book.getAuthor(),
            book.getTotal_pages(),
            categoryMapper.convertCategoriesToDto(book.getCategories()),
            book.getCreatedAt()))
        .collect(Collectors.toList());
  }
}
