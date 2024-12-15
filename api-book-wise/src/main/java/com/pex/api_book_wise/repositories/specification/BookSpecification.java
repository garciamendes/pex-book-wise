package com.pex.api_book_wise.repositories.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.pex.api_book_wise.domains.book.Book;
import com.pex.api_book_wise.dtos.BookFiltersDTO;

import jakarta.persistence.criteria.Predicate;

public class BookSpecification {
  public static Specification<Book> getSpecification(BookFiltersDTO filterDto) {
    return (root, query, criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (filterDto.getSearch() != null) {
        String searchPattern = "%" + filterDto.getSearch().toLowerCase() + "%";
        Predicate titlePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), searchPattern);
        Predicate authorPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), searchPattern);

        predicates.add(criteriaBuilder.or(titlePredicate, authorPredicate));
      }

      if (filterDto.getCategories() != null && !filterDto.getCategories().isEmpty()) {
        predicates.add(root.join("categories").get("title").in(filterDto.getCategories()));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
