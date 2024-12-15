package com.pex.api_book_wise.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.dtos.CurrentUserResponse;
import com.pex.api_book_wise.services.GetCurrentUserService;

@RestController()
@RequestMapping("/api/user")
public class GetCurrentUserController {
  @Autowired
  private GetCurrentUserService getCurrentUserService;

  @GetMapping("/current-user")
  public ResponseEntity<CurrentUserResponse> getCurrentUser() {
    return ResponseEntity.ok(this.getCurrentUserService.currentUser());
  }
}
