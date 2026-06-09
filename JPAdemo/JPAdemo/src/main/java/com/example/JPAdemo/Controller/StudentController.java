package com.example.JPAdemo.Controller;

import com.example.JPAdemo.Service.StudentSer;
import com.example.JPAdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentSer s;
    @GetMapping
    public List<Student> getStudents(){
        return s.getStudents();
    }

}