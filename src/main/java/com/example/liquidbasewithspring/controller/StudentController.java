package com.example.liquidbasewithspring.controller;

import com.example.liquidbasewithspring.entity.Student;
import com.example.liquidbasewithspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public String createStudent(@RequestParam String name) {
        Student student = new Student();
        student.setName(name);
        student.setAddress("Tashkent");
        student.setLevel("8");


        studentRepository.save(student);
        String nameToReturn = studentRepository.findByName(name);
        return studentRepository.findByName(name) + " Saved successfully";
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return  studentRepository.findAll();
    }
}
