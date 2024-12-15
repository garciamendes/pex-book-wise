package com.pex.api_book_wise.mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pex.api_book_wise.domains.book_rating.BookRating;
import com.pex.api_book_wise.dtos.BookRatingDto;

public class BookRatingMapper {
  public List<BookRatingDto> convertBooksRatingToDto(List<BookRating> books) {
    if (books == null) {
      return Collections.emptyList();
    }

    BookMapper bookMapper = new BookMapper();
    return books.stream()
        .map(book -> new BookRatingDto(
            book.getId(),
            bookMapper.convertBookToDto(book.getBook()),
            book.getRating(),
            book.getComment(),
            book.getCreatedAt()))
        .collect(Collectors.toList());
  }

  public BookRatingDto convertBookRatingToDto(BookRating book) {
    if (book == null) {
      return null;
    }

    BookMapper bookMapper = new BookMapper();
    return new BookRatingDto(
        book.getId(),
        bookMapper.convertBookToDto(book.getBook()),
        book.getRating(),
        book.getComment(),
        book.getCreatedAt());
  }
}
