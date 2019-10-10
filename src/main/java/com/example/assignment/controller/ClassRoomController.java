package com.example.assignment.controller;


import com.example.assignment.entity.Classroom;
import com.example.assignment.entity.Student;
import com.example.assignment.service.ClassroomService;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/class")
public class ClassRoomController {

    @Autowired
    ClassroomService classroomService;

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Classroom classroom = classroomService.getClassRoomById(id);
        if (classroom == null) {
            return "error/404";
        }
        model.addAttribute("classroom", classroom);
        return "classroom/detail";
    }
}
