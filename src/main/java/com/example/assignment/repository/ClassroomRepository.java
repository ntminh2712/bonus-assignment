package com.example.assignment.repository;

import com.example.assignment.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
