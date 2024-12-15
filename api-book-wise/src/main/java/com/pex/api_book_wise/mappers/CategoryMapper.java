package com.pex.api_book_wise.mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pex.api_book_wise.domains.category.Category;
import com.pex.api_book_wise.dtos.CategoryDto;

public class CategoryMapper {
  public List<CategoryDto> convertCategoriesToDto(List<Category> categories) {
    if (categories == null) {
      return Collections.emptyList();
    }

    return categories.stream()
        .map(category -> new CategoryDto(
            category.getId(),
            category.getTitle()))
        .collect(Collectors.toList());
  }

  public CategoryDto convertCategoryToDto(Category category) {
    if (category == null) {
      return null;
    }

    return new CategoryDto(
        category.getId(),
        category.getTitle());
  }
}
