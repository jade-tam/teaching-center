package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;

import java.util.List;

public interface ClassroomService {

    List<ClassroomResponse> getAllClassrooms();

    ClassroomResponse getClassroom(Integer id);

    ClassroomResponse createNewClassroom(CreateClassroomRequest request);

    ClassroomResponse updateClassroom(Integer id, UpdateClassroomRequest request);

    ClassroomResponse patchClassroom(Integer id, PatchClassroomRequest request);

    void deleteClassroom(Integer id);
}
