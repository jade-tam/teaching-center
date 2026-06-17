package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;

import java.util.List;

public interface ClassroomService {

    List<ClassroomResponse> getAllClassrooms();

    ClassroomResponse getClassroom(Long id);

    ClassroomResponse createNewClassroom(CreateClassroomRequest request);

    ClassroomResponse updateClassroom(Long id, UpdateClassroomRequest request);

    ClassroomResponse patchClassroom(Long id, PatchClassroomRequest request);

    void deleteClassroom(Long id);
}
