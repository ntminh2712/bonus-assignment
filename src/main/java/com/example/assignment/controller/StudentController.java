package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {


    @Autowired
    StudentService studentService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "error/404";
        }
        model.addAttribute("student", student);
        return "student/detail";
    }
}
