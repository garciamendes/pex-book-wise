package com.pex.api_book_wise.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.dtos.BookDto;
import com.pex.api_book_wise.services.GetCurrentReadingBookService;

@RestController()
@RequestMapping("/api/books")
public class getCurrentReadingBookController {
  @Autowired
  private GetCurrentReadingBookService getCurrentReadingBookService;

  @GetMapping("/current-reading-book")
  public ResponseEntity<BookDto> getCurrentReadingBook() {
    return ResponseEntity.ok(this.getCurrentReadingBookService.execute());
  }
}
