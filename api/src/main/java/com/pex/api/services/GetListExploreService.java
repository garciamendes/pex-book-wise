package com.pex.api.services;

import com.pex.api.dtos.BookFiltersDTO;
import com.pex.api.dtos.BookInDTO;
import com.pex.api.entities.Book;
import com.pex.api.repositories.BookRepository;
import com.pex.api.repositories.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetListExploreService {
    private final BookRepository bookRepository;

    public GetListExploreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> getList(BookInDTO bookInDto) {
        BookFiltersDTO filters = new BookFiltersDTO.Builder()
                .search(bookInDto.getSearch())
                .categories(bookInDto.getCategories())
                .build();

        PageRequest pageRequest = PageRequest.of(bookInDto.getPage(), 12);
        Specification<Book> specification = BookSpecification.getSpecification(filters);
        return this.bookRepository.findAll(specification, pageRequest);
    }
}
