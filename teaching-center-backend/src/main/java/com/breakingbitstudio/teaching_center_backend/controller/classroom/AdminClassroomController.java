package com.breakingbitstudio.teaching_center_backend.controller.classroom;

import com.breakingbitstudio.teaching_center_backend.dto.common.ApiResponse;
import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/classrooms")
public class AdminClassroomController {

    private final ClassroomService classroomService;

    public AdminClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ApiResponse<List<ClassroomResponse>> getAllClassrooms() {
        return ApiResponse.success(
                HttpStatus.OK,
                classroomService.getAllClassrooms()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<ClassroomResponse> getClassroom(@PathVariable Long id) {
        return ApiResponse.success(HttpStatus.OK, classroomService.getClassroom(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ClassroomResponse> createClassroom(@Valid @RequestBody CreateClassroomRequest request) {
        return ApiResponse.success(HttpStatus.CREATED, classroomService.createNewClassroom(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<ClassroomResponse> updateClassroom(@PathVariable Long id, @Valid @RequestBody UpdateClassroomRequest request) {
        return ApiResponse.success(HttpStatus.OK, classroomService.updateClassroom(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}
