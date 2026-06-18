package com.breakingbitstudio.teaching_center_backend.util;

import com.breakingbitstudio.teaching_center_backend.dto.common.QueryOptions;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PageableUtils {

    private PageableUtils() {
    }

    public static Pageable from(QueryOptions query) {

        Sort sort = Sort.by(
                query.getSortDirection(),
                query.getSortBy()
        );

        return PageRequest.of(
                query.getPage() - 1,
                query.getSize(),
                sort
        );
    }
}
