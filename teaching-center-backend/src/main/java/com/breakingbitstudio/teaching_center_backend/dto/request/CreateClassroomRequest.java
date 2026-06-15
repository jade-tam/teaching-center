package com.breakingbitstudio.teaching_center_backend.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record CreateClassroomRequest(
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
