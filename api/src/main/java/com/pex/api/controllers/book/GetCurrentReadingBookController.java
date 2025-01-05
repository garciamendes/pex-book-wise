package com.pex.api.controllers.book;

import com.pex.api.dtos.BookDto;
import com.pex.api.services.GetCurrentReadingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books")
public class GetCurrentReadingBookController {
    @Autowired
    private GetCurrentReadingBookService getCurrentReadingBookService;

    @GetMapping("/current-reading-book")
    public ResponseEntity<BookDto> getCurrentReadingBook() {
        return ResponseEntity.ok(this.getCurrentReadingBookService.execute());
    }
}
