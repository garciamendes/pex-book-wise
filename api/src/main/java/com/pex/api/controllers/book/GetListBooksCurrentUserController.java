package com.pex.api.controllers.book;

import com.pex.api.dtos.BookDto;
import com.pex.api.dtos.BookInDTO;
import com.pex.api.dtos.PaginationResponse;
import com.pex.api.services.GetListBooksCurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books")
public class GetListBooksCurrentUserController {
    @Autowired
    private GetListBooksCurrentUserService getListBooksCurrentUserService;

    @GetMapping("/list-current-user")
    public PaginationResponse<BookDto> getListBooksCurrentUser(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) String search) {

        BookInDTO filters = new BookInDTO();
        filters.setSearch(search);
        filters.setPage(page);

        Page<BookDto> books = this.getListBooksCurrentUserService.execute(filters);
        Integer next = books.hasNext() ? books.getNumber() + 1 : null;
        Integer previous = books.hasPrevious() ? books.getNumber() - 1 : null;

        return new PaginationResponse<BookDto>(books, next, previous);
    }
}
