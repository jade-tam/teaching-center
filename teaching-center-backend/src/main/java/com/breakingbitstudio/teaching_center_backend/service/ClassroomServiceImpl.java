package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import com.breakingbitstudio.teaching_center_backend.entity.User;
import com.breakingbitstudio.teaching_center_backend.exception.ResourceNotFoundException;
import com.breakingbitstudio.teaching_center_backend.repository.ClassroomRepository;
import com.breakingbitstudio.teaching_center_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final UserRepository userRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, UserRepository userRepository) {
        this.classroomRepository = classroomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClassroomResponse> getAllClassrooms() {
        return classroomRepository.findAll().stream().map(ClassroomResponse::from).toList();
    }

    @Override
    public ClassroomResponse getClassroom(Long id) {
        Classroom foundClassroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));

        return ClassroomResponse.from(foundClassroom);
    }

    @Override
    public ClassroomResponse createNewClassroom(CreateClassroomRequest request) {
        User teacher = userRepository.findById(request.teacherId()).orElseThrow();

        Classroom classroom = new Classroom(
                request.name(),
                request.description(),
                request.thumbnailUrl(),
                teacher,
                request.totalSessions(),
                request.maxStudents(),
                request.enrollmentDeadline(),
                request.archived()
        );

        Classroom savedClassroom = classroomRepository.save(classroom);

        return ClassroomResponse.from(savedClassroom);
    }

    @Override
    public ClassroomResponse updateClassroom(Long id, UpdateClassroomRequest request) {

        Classroom classroom = classroomRepository.findById(id).orElseThrow();

        classroom.setName(request.name());
        classroom.setDescription(request.description());
        classroom.setThumbnailUrl(request.thumbnailUrl());
        classroom.setTeacher(userRepository.findById(request.teacherId()).orElseThrow());
        classroom.setTotalSessions(request.totalSessions());
        classroom.setMaxStudents(request.maxStudents());
        classroom.setEnrollmentDeadline(request.enrollmentDeadline());
        classroom.setArchived(request.archived());

        Classroom savedClassroom = classroomRepository.save(classroom);

        return ClassroomResponse.from(savedClassroom);
    }

    @Override
    public ClassroomResponse patchClassroom(Long id, PatchClassroomRequest request) {
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
            classroom.setTeacher(userRepository.findById(request.teacherId()).orElseThrow(() -> new ResourceNotFoundException("Teacher not found")));
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
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}
