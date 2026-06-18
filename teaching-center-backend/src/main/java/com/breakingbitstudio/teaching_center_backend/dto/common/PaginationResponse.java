package com.breakingbitstudio.teaching_center_backend.dto.common;

import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> pageData;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private boolean first;
    private boolean last;
    private boolean hasPrevious;
    private boolean hasNext;

    public PaginationResponse() {
    }

    public PaginationResponse(List<T> pageData, Integer page, Integer size, Long totalElements, Integer totalPages, boolean first, boolean last, boolean hasPrevious, boolean hasNext) {
        this.pageData = pageData;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
    }

    public static <T> PaginationResponse<T> from(Page<T> page) {
        return new PaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1, // Returned page number start from 1
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasPrevious(),
                page.hasNext()
        );
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
