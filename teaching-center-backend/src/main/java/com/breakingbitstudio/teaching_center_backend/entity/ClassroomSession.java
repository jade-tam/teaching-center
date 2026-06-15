package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ClassroomSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    private Integer sessionNumber;

    private LocalDate sessionDate;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    protected ClassroomSession() {
    }

    public ClassroomSession(Classroom classroom, Integer sessionNumber, LocalDate sessionDate, LocalDateTime startTime, LocalDateTime endTime) {
        this.classroom = classroom;
        this.sessionNumber = sessionNumber;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public Integer getSessionNumber() {
        return sessionNumber;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setSessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
