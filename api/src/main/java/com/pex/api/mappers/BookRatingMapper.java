package com.pex.api.mappers;

import com.pex.api.dtos.BookRatingDto;
import com.pex.api.entities.BookRating;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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