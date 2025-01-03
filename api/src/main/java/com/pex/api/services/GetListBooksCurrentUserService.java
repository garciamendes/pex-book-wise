package com.pex.api.services;

import com.pex.api.dtos.BookDto;
import com.pex.api.dtos.BookFiltersDTO;
import com.pex.api.dtos.BookInDTO;
import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.entities.Book;
import com.pex.api.mappers.BookMapper;
import com.pex.api.repositories.BookRepository;
import com.pex.api.repositories.specification.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetListBooksCurrentUserService {
    private final BookRepository bookRepository;

    public GetListBooksCurrentUserService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<BookDto> execute(BookInDTO bookInDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();
        Account user = authUser.getAccount();

        BookFiltersDTO filters = new BookFiltersDTO.Builder()
                .search(bookInDto.getSearch())
                .build();

        Specification<Book> specification = Specification
                .where(BookSpecification.getSpecification(filters))
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.isMember(user, root.get("users")));

        PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
        Page<Book> books = this.bookRepository.findAll(specification, pageRequest);

        BookMapper bookMapper = new BookMapper();
        return books.map(bookMapper::convertBookToDto);
    }
}

