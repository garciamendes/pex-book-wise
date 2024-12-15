package com.pex.api_book_wise.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.dtos.BookDto;
import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.dtos.PaginationResponse;
import com.pex.api_book_wise.services.GetListBooksCurrentUserService;

@RestController()
@RequestMapping("/api/books")
public class GetListBooksCurrentUserController {
  @Autowired
  private GetListBooksCurrentUserService getListBooksCurrentUserService;

  @GetMapping("/list-current-user")
  public PaginationResponse<BookDto> getListBooksCurrentUser(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(required = false) String search) {

    BookInDTO filters = new BookInDTO();
    filters.setSearch(search);
    filters.setPage(page);

    Page<BookDto> books = this.getListBooksCurrentUserService.execute(filters);
    Integer next = books.hasNext() ? books.getNumber() + 1 : null;
    Integer previous = books.hasPrevious() ? books.getNumber() - 1 : null;

    return new PaginationResponse<BookDto>(books, next, previous);
  }
}
