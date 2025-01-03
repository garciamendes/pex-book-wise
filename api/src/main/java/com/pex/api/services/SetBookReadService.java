package com.pex.api.services;

import java.util.Optional;
import java.util.UUID;

import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.entities.Book;
import com.pex.api.repositories.BookRepository;
import com.pex.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SetBookReadService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public SetBookReadService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void execute(UUID book_id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();
        Account user = authUser.getAccount();

        if (user.getCurrentReadingBook() != null) {
            throw new RuntimeException("There is already a book reading");
        }

        Optional<Book> book = this.bookRepository.findById(book_id);

        if (user.getBooks().stream().anyMatch(b -> b.getId().equals(book.get().getId()))) {
            throw new RuntimeException("This book has already been read");
        }

        user.setCurrentReadingBook(book.get());
        this.userRepository.save(user);
    }
}
