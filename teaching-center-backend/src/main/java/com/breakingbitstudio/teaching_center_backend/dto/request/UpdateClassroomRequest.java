package com.breakingbitstudio.teaching_center_backend.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UpdateClassroomRequest(
        @NotBlank
        String name,

        String description,

        String thumbnailUrl,

        Integer teacherId,

        @Positive
        Integer totalSessions,

        @Positive
        Integer maxStudents,

        @Future
        LocalDateTime enrollmentDeadline,

        Boolean archived
) {

}
