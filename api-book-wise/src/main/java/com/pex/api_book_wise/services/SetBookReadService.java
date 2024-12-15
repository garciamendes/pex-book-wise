package com.pex.api_book_wise.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.repositories.BookRepository;
import com.pex.api_book_wise.repositories.UserRepository;

@Service
public class SetBookReadService {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private UserRepository userRepository;

  public void execute(UUID book_id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Auth authUser = (Auth) auth.getPrincipal();
    User user = authUser.getUser();

    if (user.getCurrentReadingBook() != null) {
      throw new RuntimeException("Has book reading");
    }

    Optional<Book> book = this.bookRepository.findById(book_id);

    user.setCurrentReadingBook(book.get());
    this.userRepository.save(user);
  }
}
