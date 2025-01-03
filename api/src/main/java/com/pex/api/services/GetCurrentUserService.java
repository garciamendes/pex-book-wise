package com.pex.api.services;

import com.pex.api.dtos.CurrentUserDto;
import com.pex.api.dtos.CurrentUserResponse;
import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentUserService {
    public CurrentUserResponse currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();

        Account user = authUser.getAccount();

        CurrentUserDto userDto = new CurrentUserDto(
                user.getId(),
                user.getName(),
                user.getTotalPagesReaded(),
                user.getTotalNumberBooksEvaluated(),
                user.getTotalAuthorReaded(),
                user.getCreatedAt());

        return new CurrentUserResponse(authUser.getId(), authUser.getEmail(), userDto);
    }
}

