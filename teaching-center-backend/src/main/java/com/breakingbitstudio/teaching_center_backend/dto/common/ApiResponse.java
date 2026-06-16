package com.breakingbitstudio.teaching_center_backend.dto.common;

import java.time.Instant;
import java.util.Map;

public record ApiResponse<T>(
        boolean success,
        int status,
        String code,
        String message,
        T data,
        Map<String, String> errors,
        Instant timestamp
) {}