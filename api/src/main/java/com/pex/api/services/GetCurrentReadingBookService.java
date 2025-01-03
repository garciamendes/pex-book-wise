package com.pex.api.services;

import com.pex.api.dtos.BookDto;
import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.mappers.BookMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentReadingBookService {
    public BookDto execute() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Auth authUser = (Auth) auth.getPrincipal();

        Account user = authUser.getAccount();

        BookMapper bookMapper = new BookMapper();
        return bookMapper.convertBookToDto(user.getCurrentReadingBook());
    }
}
