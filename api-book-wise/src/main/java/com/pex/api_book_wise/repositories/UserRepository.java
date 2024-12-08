package com.pex.api_book_wise.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pex.api_book_wise.domains.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
