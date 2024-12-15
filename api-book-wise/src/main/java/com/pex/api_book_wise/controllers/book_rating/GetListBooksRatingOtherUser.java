package com.pex.api_book_wise.controllers.book_rating;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.dtos.BookRatingDto;
import com.pex.api_book_wise.dtos.PaginationResponse;
import com.pex.api_book_wise.services.GetListBooksRatingOtherUserService;

@RestController()
@RequestMapping("/api/books-rating")
public class GetListBooksRatingOtherUser {
  @Autowired
  private GetListBooksRatingOtherUserService getListBooksRatingOtherUserService;;

  @GetMapping("/{id}")
  public PaginationResponse<BookRatingDto> getCurrentReadingBook(
      @PathVariable UUID id,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(required = false) String search) {
    BookInDTO filters = new BookInDTO();
    filters.setSearch(search);
    filters.setPage(page);

    Page<BookRatingDto> books = this.getListBooksRatingOtherUserService.execute(id, filters);
    Integer next = books.hasNext() ? books.getNumber() + 1 : null;
    Integer previous = books.hasPrevious() ? books.getNumber() - 1 : null;

    return new PaginationResponse<BookRatingDto>(books, next, previous);
  }
}