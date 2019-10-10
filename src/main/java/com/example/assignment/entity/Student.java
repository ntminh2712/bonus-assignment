package com.example.assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Roll Number can not be null or empty!")
    private String rollNumber;

    @NotNull(message = "Name can not be null or empty!")
    @Size(min = 5, max = 30, message = "Name length must be 5 - 30 characters.")
    private String name;

    @NotNull(message = "Email can not be null or empty!")
    @Email(message = "Invalid email")
    private String email;
    @NotNull(message = "Name can not be null or empty!")
    @Size(min = 5, max = 30, message = "Name length must be 5 - 30 characters.")
    private String password;
    @ManyToMany(mappedBy = "studentSet",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Classroom> classroomSet;

    public Student() {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Classroom> getClassroomSet() {
        return classroomSet;
    }

    public void setClassroomSet(Set<Classroom> classroomSet) {
        this.classroomSet = classroomSet;
    }
}
