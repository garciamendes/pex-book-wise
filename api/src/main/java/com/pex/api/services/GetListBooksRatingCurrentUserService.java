package com.pex.api.services;

import com.pex.api.dtos.BookFiltersDTO;
import com.pex.api.dtos.BookInDTO;
import com.pex.api.dtos.BookRatingDto;
import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.entities.BookRating;
import com.pex.api.mappers.BookRatingMapper;
import com.pex.api.repositories.BookRatingRepository;
import com.pex.api.repositories.specification.BookRatingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetListBooksRatingCurrentUserService {
    @Autowired
    private BookRatingRepository bookRatingRepository;

    public Page<BookRatingDto> execute(BookInDTO bookInDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();
        Account user = authUser.getAccount();

        BookFiltersDTO filters = new BookFiltersDTO.Builder()
                .search(bookInDto.getSearch())
                .build();

        Specification<BookRating> specification = Specification
                .where(BookRatingSpecification.getSpecification(filters))
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("user"), user));

        PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
        Page<BookRating> booksRating = this.bookRatingRepository.findAll(specification, pageRequest);

        BookRatingMapper bookRatingMapper = new BookRatingMapper();
        return booksRating.map(bookRatingMapper::convertBookRatingToDto);
    }
}
