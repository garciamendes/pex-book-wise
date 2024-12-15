package com.pex.api_book_wise.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.BookDto;
import com.pex.api_book_wise.mappers.BookMapper;

@Service
public class GetCurrentReadingBookService {
  public BookDto execute() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Auth authUser = (Auth) auth.getPrincipal();

    User user = authUser.getUser();

    BookMapper bookMapper = new BookMapper();
    BookDto currentReadingBook = bookMapper.convertBookToDto(user.getCurrentReadingBook());

    return currentReadingBook;
  }
}
