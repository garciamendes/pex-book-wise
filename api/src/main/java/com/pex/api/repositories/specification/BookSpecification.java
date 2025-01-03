package com.pex.api.repositories.specification;

import java.util.ArrayList;
import java.util.List;

import com.pex.api.dtos.BookFiltersDTO;
import com.pex.api.entities.Book;
import org.springframework.data.jpa.domain.Specification;


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
                predicates.add(root.join("categories").get("slug").in(filterDto.getCategories()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

