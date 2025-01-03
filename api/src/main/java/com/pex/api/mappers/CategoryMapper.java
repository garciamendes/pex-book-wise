package com.pex.api.mappers;

import com.pex.api.dtos.CategoryDto;
import com.pex.api.entities.Category;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CategoryMapper {
    public List<CategoryDto> convertCategoriesToDto(List<Category> categories) {
        if (categories == null) {
            return Collections.emptyList();
        }

        return categories.stream()
                .map(category -> new CategoryDto(
                        category.getId(),
                        category.getTitle(),
                        category.getSlug()))
                .collect(Collectors.toList());
    }

    public CategoryDto convertCategoryToDto(Category category) {
        if (category == null) {
            return null;
        }

        return new CategoryDto(
                category.getId(),
                category.getTitle(),
                category.getSlug());
    }
}
