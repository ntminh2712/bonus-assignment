package com.example.assignment.repository;

import com.example.assignment.entity.Student;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student  getStudentByEmail(String email);

}
