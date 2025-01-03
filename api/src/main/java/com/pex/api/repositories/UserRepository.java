package com.pex.api.repositories;

import com.pex.api.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Account, UUID> {

}