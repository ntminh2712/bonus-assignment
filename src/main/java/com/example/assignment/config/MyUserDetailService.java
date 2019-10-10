package com.example.assignment.config;

import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentService.getStudentByEmail(email);

        if (student == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        UserDetails user =
                User.builder()
                        .username(student.getEmail())
                        .password(student.getPassword())
                        .roles("")
                        .build();
        return user;
    }
}
