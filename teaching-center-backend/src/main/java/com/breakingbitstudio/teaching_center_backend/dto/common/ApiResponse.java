package com.breakingbitstudio.teaching_center_backend.dto.common;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

public class ApiResponse<T> {
    private boolean success;
    private int status;
    private String code;
    private String message;
    private T data;
    private Map<String, String> errors;
    private Instant timestamp;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, int status, String code, String message, T data, Map<String, String> errors, Instant timestamp) {
        this.success = success;
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public static <T> ApiResponse<T> success(HttpStatus status, T data) {
        return new ApiResponse<>(
                true,
                status.value(),
                status.name(),
                status.getReasonPhrase(),
                data,
                null,
                Instant.now()
        );
    }

    public static <T> ApiResponse<T> error(HttpStatus status, String code, String message, Map<String, String> errors) {
        return new ApiResponse<>(
                false,
                status.value(),
                code,
                message,
                null,
                errors,
                Instant.now()
        );
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ApiResponse<?> that)) return false;
        return isSuccess() == that.isSuccess() && getStatus() == that.getStatus() && Objects.equals(getCode(), that.getCode()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getData(), that.getData()) && Objects.equals(getErrors(), that.getErrors()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSuccess(), getStatus(), getCode(), getMessage(), getData(), getErrors(), getTimestamp());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponse{");
        sb.append("success=").append(success);
        sb.append(", status=").append(status);
        sb.append(", code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append(", errors=").append(errors);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}