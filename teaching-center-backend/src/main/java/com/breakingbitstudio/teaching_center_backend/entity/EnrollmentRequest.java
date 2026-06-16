package com.breakingbitstudio.teaching_center_backend.entity;

import com.breakingbitstudio.teaching_center_backend.constant.EnrollmentRequestStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class EnrollmentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private User student;

    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @Enumerated(EnumType.STRING)
    private EnrollmentRequestStatus status;

    private String rejectionReason;

    private Instant rejectedAt;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public EnrollmentRequest() {
    }

    public EnrollmentRequest(User student, Classroom classroom, EnrollmentRequestStatus status, String rejectionReason, Instant rejectedAt) {
        this.student = student;
        this.classroom = classroom;
        this.status = status;
        this.rejectionReason = rejectionReason;
        this.rejectedAt = rejectedAt;
    }

    public Long getId() {
        return id;
    }

    public User getStudent() {
        return student;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public EnrollmentRequestStatus getStatus() {
        return status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Instant getRejectedAt() {
        return rejectedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(EnrollmentRequestStatus status) {
        this.status = status;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public void setRejectedAt(Instant rejectedAt) {
        this.rejectedAt = rejectedAt;
    }
}
