package com.pex.api_book_wise.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pex.api_book_wise.domains.book.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
