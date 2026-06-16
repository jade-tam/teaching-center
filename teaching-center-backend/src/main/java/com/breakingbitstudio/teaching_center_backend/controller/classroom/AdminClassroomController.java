package com.breakingbitstudio.teaching_center_backend.controller.classroom;

import com.breakingbitstudio.teaching_center_backend.dto.request.CreateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.request.UpdateClassroomRequest;
import com.breakingbitstudio.teaching_center_backend.dto.response.ClassroomResponse;
import com.breakingbitstudio.teaching_center_backend.service.ClassroomService;
import jakarta.validation.Valid;
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
    public List<ClassroomResponse> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ClassroomResponse getClassroom(@PathVariable Long id) {
        return classroomService.getClassroom(id);
    }

    @PostMapping
    public ClassroomResponse createClassroom(@Valid @RequestBody CreateClassroomRequest request) {
        return classroomService.createNewClassroom(request);
    }

    @PutMapping("/{id}")
    public ClassroomResponse updateClassroom(@PathVariable Long id, @Valid @RequestBody UpdateClassroomRequest request) {
        return classroomService.updateClassroom(id, request);
    }

    @DeleteMapping("/{id}")
    public void updateClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}
