package com.breakingbitstudio.teaching_center_backend.service;

import com.breakingbitstudio.teaching_center_backend.dto.common.PaginationResponse;
import com.breakingbitstudio.teaching_center_backend.dto.query.ClassroomQuery;
import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.PatchClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;

public interface ClassroomService {

    PaginationResponse<ClassroomResponse> getClassrooms(ClassroomQuery query);

    ClassroomResponse getClassroom(Long id);

    ClassroomResponse createNewClassroom(CreateClassroomRequest request);

    ClassroomResponse updateClassroom(Long id, UpdateClassroomRequest request);

    ClassroomResponse patchClassroom(Long id, PatchClassroomRequest request);

    void deleteClassroom(Long id);
}
