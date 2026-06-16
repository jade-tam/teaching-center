package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    private Integer totalSessions;

    private Integer maxStudents;

    private LocalDateTime enrollmentDeadline;

    private Boolean archived;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Classroom() {
    }

    public Classroom(String name, String description, String thumbnailUrl, User teacher, Integer totalSessions, Integer maxStudents, LocalDateTime enrollmentDeadline, Boolean archived) {
        this.name = name;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.teacher = teacher;
        this.totalSessions = totalSessions;
        this.maxStudents = maxStudents;
        this.enrollmentDeadline = enrollmentDeadline;
        this.archived = archived;
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

    public User getTeacher() {
        return teacher;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
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
