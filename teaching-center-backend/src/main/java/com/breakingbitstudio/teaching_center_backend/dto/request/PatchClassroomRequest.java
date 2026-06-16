package com.breakingbitstudio.teaching_center_backend.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class PatchClassroomRequest {
    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 100)
    private String description;

    @Size(min = 3, max = 200)
    private String thumbnailUrl;

    private Long teacherId;

    @Positive
    @Max(120)
    private Integer totalSessions;

    @Positive
    @Max(100)
    private Integer maxStudents;

    @Future
    private LocalDateTime enrollmentDeadline;

    private Boolean archived;

    public PatchClassroomRequest() {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PatchClassroomRequest that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getThumbnailUrl(), that.getThumbnailUrl()) && Objects.equals(getTeacherId(), that.getTeacherId()) && Objects.equals(getTotalSessions(), that.getTotalSessions()) && Objects.equals(getMaxStudents(), that.getMaxStudents()) && Objects.equals(getEnrollmentDeadline(), that.getEnrollmentDeadline()) && Objects.equals(getArchived(), that.getArchived());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getThumbnailUrl(), getTeacherId(), getTotalSessions(), getMaxStudents(), getEnrollmentDeadline(), getArchived());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatchClassroomRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", thumbnailUrl='").append(thumbnailUrl).append('\'');
        sb.append(", teacherId=").append(teacherId);
        sb.append(", totalSessions=").append(totalSessions);
        sb.append(", maxStudents=").append(maxStudents);
        sb.append(", enrollmentDeadline=").append(enrollmentDeadline);
        sb.append(", archived=").append(archived);
        sb.append('}');
        return sb.toString();
    }
}

