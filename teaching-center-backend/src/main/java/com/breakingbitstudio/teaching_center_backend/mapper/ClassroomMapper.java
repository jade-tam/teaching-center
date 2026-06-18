package com.breakingbitstudio.teaching_center_backend.mapper;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import com.breakingbitstudio.teaching_center_backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassroomMapper {

    public Classroom toEntity(CreateClassroomRequest request, User teacher) {
        return new Classroom(
                request.getName(),
                request.getDescription(),
                request.getThumbnailUrl(),
                teacher,
                request.getTotalSessions(),
                request.getMaxStudents(),
                request.getEnrollmentDeadline(),
                request.getArchived()
        );
    }

    public ClassroomResponse toResponse(Classroom classroom) {
        ClassroomResponse classroomResponse = new ClassroomResponse();

        classroomResponse.setName(classroom.getName());
        classroomResponse.setDescription(classroom.getDescription());
        classroomResponse.setThumbnailUrl(classroom.getThumbnailUrl());
        classroomResponse.setTeacherId(classroom.getTeacher() != null ? classroom.getTeacher().getId() : null);
        classroomResponse.setTotalSessions(classroom.getTotalSessions());
        classroomResponse.setMaxStudents(classroom.getMaxStudents());
        classroomResponse.setEnrollmentDeadline(classroom.getEnrollmentDeadline());
        classroomResponse.setArchived(classroom.getArchived());

        return classroomResponse;
    }


    public void updateEntity(
            Classroom classroom,
            UpdateClassroomRequest request, User teacher) {
        classroom.setName(request.getName());
        classroom.setDescription(request.getDescription());
        classroom.setThumbnailUrl(request.getThumbnailUrl());
        classroom.setTeacher(teacher);
        classroom.setTotalSessions(request.getTotalSessions());
        classroom.setMaxStudents(request.getMaxStudents());
        classroom.setEnrollmentDeadline(request.getEnrollmentDeadline());
        classroom.setArchived(request.getArchived());
    }

    public void patchEntity(
            Classroom classroom,
            PatchClassroomRequest request, User teacher) {
        if (request.getName() != null) {
            classroom.setName(request.getName());
        }
        if (request.getDescription() != null) {
            classroom.setDescription(request.getDescription());
        }
        if (request.getThumbnailUrl() != null) {
            classroom.setThumbnailUrl(request.getThumbnailUrl());
        }
        if (request.getTeacherId() != null) {
            classroom.setTeacher(teacher);
        }
        if (request.getTotalSessions() != null) {
            classroom.setTotalSessions(request.getTotalSessions());
        }
        if (request.getMaxStudents() != null) {
            classroom.setMaxStudents(request.getMaxStudents());
        }
        if (request.getEnrollmentDeadline() != null) {
            classroom.setEnrollmentDeadline(request.getEnrollmentDeadline());
        }
        if (request.getArchived() != null) {
            classroom.setArchived(request.getArchived());
        }
    }

    public List<ClassroomResponse> toResponseList(
            List<Classroom> classrooms) {

        return classrooms.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
