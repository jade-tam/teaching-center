package com.breakingbitstudio.teaching_center_backend.specification;

import com.breakingbitstudio.teaching_center_backend.dto.query.ClassroomQuery;
import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import org.springframework.data.jpa.domain.Specification;

public final class ClassroomSpecification {
    public static Specification<Classroom> from(ClassroomQuery query) {
        return Specification.where(search(query.getSearch())).and(isArchived(query.isArchived()));
    }

    private static Specification<Classroom> search(String keyword) {
        return ((root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isBlank()) return null;

            String pattern = "%" + keyword.trim().toLowerCase() + "%";

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), pattern);
        });
    }

    private static Specification<Classroom> isArchived(Boolean archived) {
        return ((root, query, criteriaBuilder) -> {
            if (archived == null) return null;
            return criteriaBuilder.equal(root.get("archived"), archived);
        });
    }
}
