package com.pex.api.dtos;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PaginationResponse<T> {
    private List<T> result;
    private int page;
    private long totalElements;
    private int totalPages;
    private Integer next;
    private Integer previous;

    public PaginationResponse(Page<T> props, Integer next, Integer previous) {
        this.page = props.getNumber();
        this.totalElements = props.getTotalElements();
        this.totalPages = props.getTotalPages();
        this.next = next;
        this.previous = previous;
        this.result = props.getContent();
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }
}