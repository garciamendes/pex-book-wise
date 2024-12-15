package com.pex.api_book_wise.controllers.book;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.dtos.ResponseMessageDTO;
import com.pex.api_book_wise.dtos.SetBookReadDto;
import com.pex.api_book_wise.services.SetBookReadService;

@RestController()
@RequestMapping("/api/books")
public class SetBookReadController {
  @Autowired
  private SetBookReadService setBookReadService;

  @PostMapping("/read")
  public ResponseEntity setBookAsRead(@RequestBody @Validated SetBookReadDto data) {
    try {
      this.setBookReadService.execute(data.book_id());

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseMessageDTO("There is already a book reading"));
    }
  }
}
