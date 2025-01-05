package com.pex.api.services;

import java.util.Optional;
import java.util.UUID;

import com.pex.api.dtos.CurrentUserDto;
import com.pex.api.entities.Account;
import com.pex.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOtherUserService {
    @Autowired
    private UserRepository userRepository;

    public CurrentUserDto execute(UUID id) {
        Optional<Account> user = this.userRepository.findById(id);

        return new CurrentUserDto(
                user.get().getId(),
                user.get().getName(),
                user.get().getTotalPagesReaded(),
                user.get().getTotalNumberBooksEvaluated(),
                user.get().getTotalAuthorReaded(),
                user.get().getCreatedAt());
    }
}
