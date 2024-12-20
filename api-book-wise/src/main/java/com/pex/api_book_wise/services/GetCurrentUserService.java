package com.pex.api_book_wise.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.CurrentUserDto;
import com.pex.api_book_wise.dtos.CurrentUserResponse;

@Service
public class GetCurrentUserService {
  public CurrentUserResponse currentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Auth authUser = (Auth) auth.getPrincipal();

    User user = authUser.getUser();

    CurrentUserDto userDto = new CurrentUserDto(
        user.getId(),
        user.getName(),
        user.getTotal_author_readed(),
        user.getTotal_number_books_evaluated(),
        user.getTotal_author_readed(),
        user.getCreatedAt());

    CurrentUserResponse currentUser = new CurrentUserResponse(authUser.getId(), authUser.getEmail(), userDto);
    return currentUser;
  }
}
