package com.pex.api_book_wise.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.CurrentUserDto;
import com.pex.api_book_wise.repositories.UserRepository;

@Service
public class GetOtherUserService {
  @Autowired
  private UserRepository userRepository;

  public CurrentUserDto execute(UUID id) {
    Optional<User> user = this.userRepository.findById(id);

    return new CurrentUserDto(
        user.get().getId(),
        user.get().getName(),
        user.get().getTotal_pages_readed(),
        user.get().getTotal_number_books_evaluated(),
        user.get().getTotal_author_readed(),
        user.get().getCreatedAt());
  }
}
