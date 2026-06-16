package com.breakingbitstudio.teaching_center_backend.entity;

import com.breakingbitstudio.teaching_center_backend.constant.EnrollmentRequestStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_Attendance_student_classroom_session",
                columnNames = {"student_id", "classroom_session_id"}
        )
})
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_session_id")
    private ClassroomSession classroomSession;

    @Enumerated(EnumType.STRING)
    private EnrollmentRequestStatus status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Attendance() {
    }

    public Attendance(User student, ClassroomSession classroomSession, EnrollmentRequestStatus status) {
        this.student = student;
        this.classroomSession = classroomSession;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User getStudent() {
        return student;
    }

    public ClassroomSession getClassroomSession() {
        return classroomSession;
    }

    public EnrollmentRequestStatus getStatus() {
        return status;
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
}
