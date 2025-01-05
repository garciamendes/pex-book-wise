package com.pex.api.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BookInDTO {
    private String search;
    private List<String> categories;
    private Integer page;

    public BookInDTO(String search, List<String> categories, Integer page) {
        this.search = search;
        this.categories = categories;
        this.page = page;
    }

    public BookInDTO() {}

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
