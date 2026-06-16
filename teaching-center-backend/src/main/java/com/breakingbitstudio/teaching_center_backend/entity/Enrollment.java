package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_enrollment_student_classroom",
                columnNames = {"student_id", "classroom_id"}
        )
})
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Enrollment() {
    }

    public Enrollment(User student, Classroom classroom) {
        this.student = student;
        this.classroom = classroom;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
