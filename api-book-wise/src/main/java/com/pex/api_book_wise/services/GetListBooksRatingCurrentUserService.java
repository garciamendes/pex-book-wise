package com.pex.api_book_wise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.book_rating.BookRating;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.BookFiltersDTO;
import com.pex.api_book_wise.dtos.BookInDTO;
import com.pex.api_book_wise.dtos.BookRatingDto;
import com.pex.api_book_wise.mappers.BookRatingMapper;
import com.pex.api_book_wise.repositories.BookRatingRepository;
import com.pex.api_book_wise.repositories.specification.BookRatingSpecification;

@Service
public class GetListBooksRatingCurrentUserService {
  @Autowired
  private BookRatingRepository bookRatingRepository;

  public Page<BookRatingDto> execute(BookInDTO bookInDto) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Auth authUser = (Auth) auth.getPrincipal();
    User user = authUser.getUser();

    BookFiltersDTO filters = BookFiltersDTO.builder()
        .search(bookInDto.getSearch())
        .build();

    Specification<BookRating> specification = Specification
        .where(BookRatingSpecification.getSpecification(filters))
        .and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user"), user));

    PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
    Page<BookRating> booksRating = this.bookRatingRepository.findAll(specification, pageRequest);

    BookRatingMapper bookRatingMapper = new BookRatingMapper();
    return booksRating.map(bookRatingMapper::convertBookRatingToDto);
  }
}
