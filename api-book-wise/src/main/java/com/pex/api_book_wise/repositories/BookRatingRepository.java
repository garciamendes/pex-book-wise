package com.pex.api_book_wise.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pex.api_book_wise.domains.book_rating.BookRating;

public interface BookRatingRepository extends JpaRepository<BookRating, UUID>, JpaSpecificationExecutor<BookRating> {
  @SuppressWarnings("null")
  List<BookRating> findAll(Specification<BookRating> specification);
}
