package com.pex.api.controllers.user;

import java.util.UUID;

import com.pex.api.dtos.CurrentUserDto;
import com.pex.api.services.GetOtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/user")
public class GetOtherUserController {
    @Autowired
    private GetOtherUserService getOtherUserService;

    @GetMapping("/{id}")
    public ResponseEntity<CurrentUserDto> getOtherUser(@PathVariable UUID id) {
        return ResponseEntity.ok(this.getOtherUserService.execute(id));
    }
}
