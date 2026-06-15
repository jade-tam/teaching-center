package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Classroom {
    @Id
    private Integer id;
    
    private String name;

    private String description;

    private String thumbnailUrl;

    private Integer teacherId;

    private Integer totalSessions;

    private Integer maxStudents;

    private LocalDateTime enrollmentDeadline;

    private boolean archived;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Classroom() {
    }

    public Classroom(String name, String description, String thumbnailUrl, Integer teacherId) {
        this.name = name;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.teacherId = teacherId;
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

    public boolean isArchived() {
        return archived;
    }

    public Integer getId() {
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
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

    public void setTeacherId(Integer teacherId) {
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

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
