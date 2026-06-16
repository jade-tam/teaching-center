package com.breakingbitstudio.teaching_center_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class GradeComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    private String componentName;

    @Column(precision = 5, scale = 2)
    private BigDecimal weight;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public GradeComponent() {
    }

    public GradeComponent(Classroom classroom, String componentName, BigDecimal weight) {
        this.classroom = classroom;
        this.componentName = componentName;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public String getComponentName() {
        return componentName;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
