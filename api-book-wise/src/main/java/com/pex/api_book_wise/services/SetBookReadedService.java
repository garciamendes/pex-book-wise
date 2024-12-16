package com.pex.api_book_wise.services;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.domains.category.Category;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.repositories.UserRepository;

@Service
public class SetBookReadedService {
  @Autowired
  private UserRepository userRepository;

  public void execute() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Auth authUser = (Auth) auth.getPrincipal();
    User user = authUser.getUser();

    Book currentBookReading = user.getCurrentReadingBook();

    if (currentBookReading == null) {
      throw new RuntimeException("There is no book being read");
    }

    user.getCategoryReadCounts().size();
    user.setTotal_pages_readed(user.getTotal_pages_readed() + currentBookReading.getTotal_pages());

    boolean isNewAuthor = user.getBooks().stream()
        .noneMatch(b -> b.getAuthor().equals(currentBookReading.getAuthor()));

    if (isNewAuthor) {
      user.setTotal_author_readed(user.getTotal_author_readed() + 1);
    }
    user.getBooks().add(currentBookReading);

    Set<Category> existingCategories = user.getBooks().stream()
        .flatMap(b -> b.getCategories().stream())
        .collect(Collectors.toSet());

    currentBookReading.getCategories().forEach(category -> {
      if (!existingCategories.contains(category)) {
        user.getCategoryReadCounts().put(
            category,
            user.getCategoryReadCounts().getOrDefault(category, 0) + 1);
        existingCategories.add(category);
      }
    });

    user.setMost_read_category(user.getCategoryReadCounts().entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null));

    user.setCurrentReadingBook(null);

    this.userRepository.save(user);
  }
}
