package com.pex.api_book_wise.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.BookDto;
import com.pex.api_book_wise.dtos.BookFiltersDTO;
import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.mappers.BookMapper;
import com.pex.api_book_wise.repositories.BookRepository;
import com.pex.api_book_wise.repositories.UserRepository;
import com.pex.api_book_wise.repositories.specification.BookSpecification;

@Service
public class GetListBooksRatingOtherUserService {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private UserRepository userRepository;

  public Page<BookDto> execute(UUID id, BookInDTO bookInDto) {
    Optional<User> user = this.userRepository.findById(id);

    BookFiltersDTO filters = BookFiltersDTO.builder()
        .search(bookInDto.getSearch())
        .build();

    Specification<Book> specification = Specification
        .where(BookSpecification.getSpecification(filters))
        .and((root, query, criteriaBuilder) -> criteriaBuilder.isMember(user, root.get("users")));

    PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
    Page<Book> books = this.bookRepository.findAll(specification, pageRequest);

    BookMapper bookMapper = new BookMapper();
    return books.map(bookMapper::convertBookToDto);
  }
}
