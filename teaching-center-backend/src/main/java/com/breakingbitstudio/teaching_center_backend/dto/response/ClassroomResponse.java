package com.breakingbitstudio.teaching_center_backend.dto.response;

import java.time.Instant;
import java.time.LocalDateTime;

public class ClassroomResponse {
    private Long id;

    private String name;

    private String description;

    private String thumbnailUrl;

    private Long teacherId;

    private Integer totalSessions;

    private Integer maxStudents;

    private LocalDateTime enrollmentDeadline;

    private Boolean archived;

    private Instant createdAt;

    private Instant updatedAt;

    public ClassroomResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Integer getTotalSessions() {
        return totalSessions;
    }

    public Integer getMaxStudents() {
        return maxStudents;
    }

    public LocalDateTime getEnrollmentDeadline() {
        return enrollmentDeadline;
    }

    public Boolean getArchived() {
        return archived;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTotalSessions(Integer totalSessions) {
        this.totalSessions = totalSessions;
    }

    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    public void setEnrollmentDeadline(LocalDateTime enrollmentDeadline) {
        this.enrollmentDeadline = enrollmentDeadline;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}