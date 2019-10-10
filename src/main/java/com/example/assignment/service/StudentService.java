package com.example.assignment.service;


import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(int id){

        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email){
        return studentRepository.getStudentByEmail(email);
    }


}
