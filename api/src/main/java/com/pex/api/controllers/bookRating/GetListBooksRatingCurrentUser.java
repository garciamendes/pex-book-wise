package com.pex.api.controllers.bookRating;

import com.pex.api.dtos.BookInDTO;
import com.pex.api.dtos.BookRatingDto;
import com.pex.api.dtos.PaginationResponse;
import com.pex.api.services.GetListBooksRatingCurrentUserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books-rating")
public class GetListBooksRatingCurrentUser {
    private final GetListBooksRatingCurrentUserService getListBooksRatingCurrentUserService;

    public GetListBooksRatingCurrentUser(GetListBooksRatingCurrentUserService getListBooksRatingCurrentUserService) {
        this.getListBooksRatingCurrentUserService = getListBooksRatingCurrentUserService;
    }

    @GetMapping("/list-current-user")
    public PaginationResponse<BookRatingDto> getCurrentReadingBook(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) String search) {
        BookInDTO filters = new BookInDTO();
        filters.setSearch(search);
        filters.setPage(page);

        Page<BookRatingDto> books = this.getListBooksRatingCurrentUserService.execute(filters);
        Integer next = books.hasNext() ? books.getNumber() + 1 : null;
        Integer previous = books.hasPrevious() ? books.getNumber() - 1 : null;

        return new PaginationResponse<BookRatingDto>(books, next, previous);
    }
}