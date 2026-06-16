package com.breakingbitstudio.teaching_center_backend.dto.response;

import com.breakingbitstudio.teaching_center_backend.entity.Classroom;

import java.time.Instant;
import java.time.LocalDateTime;

public record ClassroomResponse(
        Long id,

        String name,

        String description,

        String thumbnailUrl,

        Long teacherId,

        Integer totalSessions,

        Integer maxStudents,

        LocalDateTime enrollmentDeadline,

        Boolean archived,

        Instant createdAt,

        Instant updatedAt
) {

    public static ClassroomResponse from(
            Classroom classroom) {

        return new ClassroomResponse(
                classroom.getId(),
                classroom.getName(),
                classroom.getDescription(),
                classroom.getThumbnailUrl(),
                classroom.getTeacher() != null ? classroom.getTeacher().getId() : null,
                classroom.getTotalSessions(),
                classroom.getMaxStudents(),
                classroom.getEnrollmentDeadline(),
                classroom.isArchived(),
                classroom.getCreatedAt(),
                classroom.getUpdatedAt()
        );
    }
}