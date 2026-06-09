package com.example.FirstApi.Controller;

import com.example.FirstApi.Component.Student;
import com.example.FirstApi.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Student> getStudent() {
        return ResponseEntity.ok(studentService.getStudent());
    }

}