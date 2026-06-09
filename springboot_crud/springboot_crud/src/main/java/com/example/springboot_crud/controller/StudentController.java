package com.example.springboot_crud.controller;

import com.example.springboot_crud.model.Student;
import com.example.springboot_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService s; // s-> object reference

    @GetMapping("students")
    public List<Student> getAllStudent(){
        return s.getAllStudent();
    }

    @GetMapping("students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno")int roll){
        return s.getStudentByRollNo(roll);
    }

    @PostMapping("student")
    public String addStudent(@RequestBody Student std){
        s.addStudent(std);
        return "success";
    }

    @PutMapping("students/{rno}")
    public String updateStudent(@RequestBody Student std){
        s.updateStudent(std);
        return  "Updated successfully";
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudent(@PathVariable("rno") int r){
        return s.deleteStudent(r);
    }
}
