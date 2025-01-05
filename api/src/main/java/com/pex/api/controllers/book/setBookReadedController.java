package com.pex.api.controllers.book;

import com.pex.api.dtos.ResponseMessageDTO;
import com.pex.api.services.SetBookReadedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books")
public class setBookReadedController {
    private final SetBookReadedService setBookReadedService;

    public setBookReadedController(SetBookReadedService setBookReadedService) {
        this.setBookReadedService = setBookReadedService;
    }

    @PatchMapping("/read/complete")
    public ResponseEntity setBookAsRead() {
        try {
            this.setBookReadedService.execute();

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseMessageDTO(e.getMessage()));
        }
    }
}
