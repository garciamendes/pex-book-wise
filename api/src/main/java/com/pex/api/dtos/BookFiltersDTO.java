package com.pex.api.dtos;

import java.util.List;

import lombok.Builder;

public class BookFiltersDTO {
    private String search;
    private List<String> categories;

    private BookFiltersDTO(Builder builder) {
        this.search = builder.search;
        this.categories = builder.categories;
    }

    public String getSearch() {
        return search;
    }

    public List<String> getCategories() {
        return categories;
    }

    public static class Builder {
        private String search;
        private List<String> categories;

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder categories(List<String> categories) {
            this.categories = categories;
            return this;
        }

        public BookFiltersDTO build() {
            return new BookFiltersDTO(this);
        }
    }
}
