package com.example.eighthproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.eighthproject.Models.Student;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Main {

    @GetMapping("/student")
    public String getStudent(Model model) {
        Student student = new Student(101, "Anjali Sharma", 92.5f);
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Anjali Sharma", 92.5f));
        students.add(new Student(102, "Rohit Mehta", 85.0f));
        students.add(new Student(103, "Sneha Iyer", 78.6f));
        model.addAttribute("students", students);
        return "students";
    }
}
