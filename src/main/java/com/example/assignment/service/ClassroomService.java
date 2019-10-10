package com.example.assignment.service;


import com.example.assignment.entity.Classroom;
import com.example.assignment.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom getClassRoomById(int id){
        return classroomRepository.findById(id).orElse(null);
    }


}
