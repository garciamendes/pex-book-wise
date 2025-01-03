package com.pex.api.repositories;

import com.pex.api.entities.BookRating;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface BookRatingRepository extends JpaRepository<BookRating, UUID>, JpaSpecificationExecutor<BookRating> {
    List<BookRating> findAll(Specification<BookRating> specification);
}