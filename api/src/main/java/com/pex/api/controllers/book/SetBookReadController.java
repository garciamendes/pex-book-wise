package com.pex.api.controllers.book;

import com.pex.api.dtos.ResponseMessageDTO;
import com.pex.api.dtos.SetBookReadDto;
import com.pex.api.services.SetBookReadService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books")
public class SetBookReadController {
    private final SetBookReadService setBookReadService;

    public SetBookReadController(SetBookReadService setBookReadService) {
        this.setBookReadService = setBookReadService;
    }

    @PostMapping("/read")
    public ResponseEntity setBookAsRead(@RequestBody @Validated SetBookReadDto data) {
        try {
            this.setBookReadService.execute(data.bookId());

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseMessageDTO("There is already a book reading"));
        }
    }
}