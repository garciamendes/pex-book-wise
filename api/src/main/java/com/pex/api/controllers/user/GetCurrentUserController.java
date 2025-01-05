package com.pex.api.controllers.user;

import com.pex.api.dtos.CurrentUserResponse;
import com.pex.api.services.GetCurrentUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/user")
public class GetCurrentUserController {
    private final GetCurrentUserService getCurrentUserService;

    public GetCurrentUserController(GetCurrentUserService getCurrentUserService) {
        this.getCurrentUserService = getCurrentUserService;
    }

    @GetMapping("/current-user")
    public ResponseEntity<CurrentUserResponse> getCurrentUser() {
        return ResponseEntity.ok(this.getCurrentUserService.currentUser());
    }
}
