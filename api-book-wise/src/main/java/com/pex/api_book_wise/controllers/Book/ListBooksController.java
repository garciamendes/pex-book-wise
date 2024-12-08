package com.pex.api_book_wise.controllers.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.repositories.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/books")

public class ListBooksController {
  @Autowired
  private BookRepository bookRepository;

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return ResponseEntity.ok(books);
  }
}