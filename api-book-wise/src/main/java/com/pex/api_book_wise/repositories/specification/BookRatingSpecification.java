package com.pex.api_book_wise.repositories.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.pex.api_book_wise.domains.book_rating.BookRating;
import com.pex.api_book_wise.dtos.BookFiltersDTO;

import jakarta.persistence.criteria.Predicate;

public class BookRatingSpecification {
  public static Specification<BookRating> getSpecification(BookFiltersDTO filterDto) {
    return (root, query, criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (filterDto.getSearch() != null) {
        String searchPattern = "%" + filterDto.getSearch().toLowerCase() + "%";
        Predicate titlePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.join("book").get("title")),
            searchPattern);
        Predicate authorPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.join("book").get("author")),
            searchPattern);

        predicates.add(criteriaBuilder.or(titlePredicate, authorPredicate));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
