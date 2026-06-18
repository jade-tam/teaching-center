package com.breakingbitstudio.teaching_center_backend.dto.common;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Sort;

public abstract class QueryOptions {

    @Size(max = 100)
    private String search;

    @Min(1)
    private Integer page = 1;

    @Min(1)
    @Max(100)
    private Integer size = 10;

    private String sortBy = "id";

    private Sort.Direction sortDirection = Sort.Direction.ASC;

    public String getSearch() {
        return search;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }
}
