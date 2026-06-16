package com.breakingbitstudio.teaching_center_backend.repository;

import com.breakingbitstudio.teaching_center_backend.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
