package com.pex.api.services;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.entities.Book;
import com.pex.api.entities.Category;
import com.pex.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SetBookReadedService {
    private final UserRepository userRepository;

    public SetBookReadedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();
        Account user = authUser.getAccount();

        Book currentBookReading = user.getCurrentReadingBook();

        if (currentBookReading == null) {
            throw new RuntimeException("There is no book being read");
        }

        user.getCategoryReadCounts().size();
        user.setTotalPagesReaded(user.getTotalPagesReaded() + currentBookReading.getTotalPages());

        boolean isNewAuthor = user.getBooks().stream()
                .noneMatch(b -> b.getAuthor().equals(currentBookReading.getAuthor()));

        if (isNewAuthor) {
            user.setTotalAuthorReaded(user.getTotalAuthorReaded() + 1);
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

        user.setMostReadCategory(user.getCategoryReadCounts().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null));

        user.setCurrentReadingBook(null);

        this.userRepository.save(user);
    }
}
