package com.breakingbitstudio.teaching_center_backend.constant;

public enum ErrorCode {

    // Classroom
    CLASSROOM_NOT_FOUND,
    CLASSROOM_FULL,

    // User
    USER_NOT_FOUND,
    USER_ALREADY_EXISTS,
    TEACHER_NOT_FOUND,

    // Validation
    VALIDATION_FAILED,

    INTERNAL_SERVER_ERROR
}