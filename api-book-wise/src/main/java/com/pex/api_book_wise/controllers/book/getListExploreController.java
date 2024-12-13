package com.pex.api_book_wise.controllers.book;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.dtos.PaginationResponse;
import com.pex.api_book_wise.services.GetListExploreService;

@RestController()
@RequestMapping("/api/books")
public class getListExploreController {
  @Autowired
  private GetListExploreService getListExploreService;

  @GetMapping("/explore")
  public PaginationResponse<Book> getBooksExplore(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(required = false) String search,
      @RequestParam(required = false) String categories) {
    BookInDTO filters = new BookInDTO();
    filters.setSearch(search);
    filters.setPage(page);

    if (categories != null && !categories.isEmpty()) {
      filters.setCategories(Arrays.asList(categories.split(",")));
    }

    Page<Book> books = this.getListExploreService.getList(filters);

    Integer next = books.hasNext() ? books.getNumber() + 1 : null;
    Integer previous = books.hasPrevious() ? books.getNumber() - 1 : null;

    return new PaginationResponse<>(books, next, previous);
  }
}
