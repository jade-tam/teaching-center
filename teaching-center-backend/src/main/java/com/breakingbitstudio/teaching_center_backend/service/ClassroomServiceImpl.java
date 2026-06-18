package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.constant.ErrorCode;
import com.breakingbitstudio.teaching_center_backend.dto.common.PaginationResponse;
import com.breakingbitstudio.teaching_center_backend.dto.query.ClassroomQuery;
import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import com.breakingbitstudio.teaching_center_backend.entity.User;
import com.breakingbitstudio.teaching_center_backend.exception.ResourceNotFoundException;
import com.breakingbitstudio.teaching_center_backend.mapper.ClassroomMapper;
import com.breakingbitstudio.teaching_center_backend.repository.ClassroomRepository;
import com.breakingbitstudio.teaching_center_backend.repository.UserRepository;
import com.breakingbitstudio.teaching_center_backend.specification.ClassroomSpecification;
import com.breakingbitstudio.teaching_center_backend.util.PageableUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final UserRepository userRepository;
    private final ClassroomMapper classroomMapper;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, UserRepository userRepository, ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.userRepository = userRepository;
        this.classroomMapper = classroomMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public PaginationResponse<ClassroomResponse> getClassrooms(ClassroomQuery query) {
        // Testing var keyword
        var specification = ClassroomSpecification.from(query);
        Pageable pageable = PageableUtils.from(query);

        Page<Classroom> classroomsPage = classroomRepository.findAll(specification, pageable);
        Page<ClassroomResponse> classroomResponsePage = classroomsPage.map(classroomMapper::toResponse);

        return PaginationResponse.from(classroomResponsePage);
    }

    @Override
    @Transactional(readOnly = true)
    public ClassroomResponse getClassroom(Long id) {
        Classroom foundClassroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.CLASSROOM_NOT_FOUND));

        return classroomMapper.toResponse(foundClassroom);
    }

    @Override
    @Transactional
    public ClassroomResponse createNewClassroom(CreateClassroomRequest request) {
        User teacher = null;
        if (request.getTeacherId() != null) {
            teacher = userRepository.findById(request.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.TEACHER_NOT_FOUND));
        }
        Classroom classroom = classroomMapper.toEntity(request, teacher);
        Classroom savedClassroom = classroomRepository.save(classroom);

        return classroomMapper.toResponse(savedClassroom);
    }

    @Override
    @Transactional
    public ClassroomResponse updateClassroom(Long id, UpdateClassroomRequest request) {

        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.CLASSROOM_NOT_FOUND));

        User teacher = null;
        if (request.getTeacherId() != null) {
            teacher = userRepository.findById(request.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.TEACHER_NOT_FOUND));
        }
        classroomMapper.updateEntity(classroom, request, teacher);
        Classroom savedClassroom = classroomRepository.save(classroom);

        return classroomMapper.toResponse(savedClassroom);
    }

    @Override
    @Transactional
    public ClassroomResponse patchClassroom(Long id, PatchClassroomRequest request) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.CLASSROOM_NOT_FOUND));

        User teacher = null;
        if (request.getTeacherId() != null) {
            teacher = userRepository.findById(request.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.TEACHER_NOT_FOUND));
        }
        classroomMapper.patchEntity(classroom, request, teacher);

        Classroom savedClassroom = classroomRepository.save(classroom);

        return classroomMapper.toResponse(savedClassroom);
    }

    @Override
    @Transactional
    public void deleteClassroom(Long id) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.CLASSROOM_NOT_FOUND));
        classroom.setArchived(true);
    }
}
