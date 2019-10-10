package com.example.assignment.controller;


import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "/register";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hero", student);
            return "hero/form";
        }
        studentService.addStudent(student);
        return "redirect:/student";
    }
}
