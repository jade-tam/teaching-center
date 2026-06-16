package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_grade_student_grade_component",
                columnNames = {"student_id", "grade_component_id"}
        )
})
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_component_id")
    private GradeComponent gradeComponent;

    @Column(precision = 5, scale = 2)
    private BigDecimal score;

    private String comment;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Grade() {
    }

    public Grade(User student, GradeComponent gradeComponent, BigDecimal score, String comment) {
        this.student = student;
        this.gradeComponent = gradeComponent;
        this.score = score;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public User getStudent() {
        return student;
    }

    public GradeComponent getGradeComponent() {
        return gradeComponent;
    }

    public BigDecimal getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
