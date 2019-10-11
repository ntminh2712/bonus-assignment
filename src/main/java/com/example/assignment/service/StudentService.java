package com.example.assignment.service;


import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Student getStudentById(int id){

        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email){
        return studentRepository.getStudentByEmail(email);
    }

    public List<Student> getAllStudentByListId(List<Integer> list){
        return studentRepository.findAllById(list);
    }

}
