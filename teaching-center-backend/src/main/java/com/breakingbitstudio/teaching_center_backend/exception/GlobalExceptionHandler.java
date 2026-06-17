package com.breakingbitstudio.teaching_center_backend.exception;

import com.breakingbitstudio.teaching_center_backend.constant.ErrorCode;
import com.breakingbitstudio.teaching_center_backend.dto.common.ApiResponse;
import com.breakingbitstudio.teaching_center_backend.i18n.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageService messageService;

    public GlobalExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handle(ResourceNotFoundException ex) {

        ErrorCode code = ex.getErrorCode();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(
                        false,
                        HttpStatus.NOT_FOUND.value(),
                        code.name(),
                        messageService.get(code.name()),
                        null,
                        null,
                        Instant.now()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(
                        false,
                        HttpStatus.BAD_REQUEST.value(),
                        ErrorCode.VALIDATION_FAILED.name(),
                        messageService.get(ErrorCode.VALIDATION_FAILED.name()),
                        null,
                        errors,
                        Instant.now()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(
                        false,
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ErrorCode.INTERNAL_SERVER_ERROR.name(),
                        messageService.get(ErrorCode.INTERNAL_SERVER_ERROR.name()),
                        null,
                        null,
                        Instant.now()
                ));
    }
}
