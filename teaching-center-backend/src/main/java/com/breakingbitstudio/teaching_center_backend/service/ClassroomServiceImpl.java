package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import com.breakingbitstudio.teaching_center_backend.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<ClassroomResponse> getAllClassrooms() {
        return classroomRepository.findAll().stream().map(ClassroomResponse::from).toList();
    }

    @Override
    public ClassroomResponse getClassroom(Integer id) {
        Classroom foundClassroom = classroomRepository.findById(id).orElseThrow();

        return ClassroomResponse.from(foundClassroom);
    }

    @Override
    public ClassroomResponse createNewClassroom(CreateClassroomRequest request) {
        Classroom classroom = new Classroom(
                request.name(),
                request.description(),
                request.thumbnailUrl(),
                request.teacherId(),
                request.totalSessions(),
                request.maxStudents(),
                request.enrollmentDeadline(),
                request.archived()
        );

        Classroom savedClassroom = classroomRepository.save(classroom);

        return ClassroomResponse.from(savedClassroom);
    }

    @Override
    public ClassroomResponse updateClassroom(Integer id, UpdateClassroomRequest request) {

        Classroom classroom = classroomRepository.findById(id).orElseThrow();

        classroom.setName(request.name());
        classroom.setDescription(request.description());
        classroom.setThumbnailUrl(request.thumbnailUrl());
        classroom.setTeacherId(request.teacherId());
        classroom.setTotalSessions(request.totalSessions());
        classroom.setMaxStudents(request.maxStudents());
        classroom.setEnrollmentDeadline(request.enrollmentDeadline());
        classroom.setArchived(request.archived());

        Classroom savedClassroom = classroomRepository.save(classroom);

        return ClassroomResponse.from(savedClassroom);
    }

    @Override
    public ClassroomResponse patchClassroom(Integer id, PatchClassroomRequest request) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow();

        if (request.name() != null) {
            classroom.setName(request.name());
        }

        if (request.description() != null) {
            classroom.setDescription(request.description());
        }

        if (request.thumbnailUrl() != null) {
            classroom.setThumbnailUrl(request.thumbnailUrl());
        }

        if (request.teacherId() != null) {
            classroom.setTeacherId(request.teacherId());
        }

        if (request.totalSessions() != null) {
            classroom.setTotalSessions(request.totalSessions());
        }

        if (request.maxStudents() != null) {
            classroom.setMaxStudents(request.maxStudents());
        }

        if (request.archived() != null) {
            classroom.setArchived(request.archived());
        }

        Classroom savedClassroom = classroomRepository.save(classroom);

        return ClassroomResponse.from(savedClassroom);
    }

    @Override
    public void deleteClassroom(Integer id) {
        classroomRepository.deleteById(id);
    }
}
