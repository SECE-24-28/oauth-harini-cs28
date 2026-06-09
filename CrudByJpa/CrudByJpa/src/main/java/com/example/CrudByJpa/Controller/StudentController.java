package com.example.CrudByJpa.Controller;

import com.example.CrudByJpa.Service.StudentService;
import com.example.CrudByJpa.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import com.example.CrudByJpa.Dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("/public")
    public String publicApi() {
        return "This is a Public API";
    }

    @GetMapping("/private")
    public String privateApi() {
        return "This is a Private API";
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return s.getAllStudents();
    }

    @PostMapping("student")
    public String addStudents(@Valid @RequestBody Student std){
        s.addStudent(std);
        return "added";
    }

    @GetMapping("students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno") int roll){
        return s.getStudentByRollNo(roll);
    }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student std){
        s.updateStudent(std);
        return "updated";
    }

    @DeleteMapping("students")
    public String deleteAllStudents(){
        s.deleteAllStudents();
        return "Deleted";
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudentByAll(@PathVariable("rno") int roll){
        s.deleteStudentByRollNo(roll);
        return "Deleted successfully";
    }

    @GetMapping("students/custom")
    public List<Student> getStudentByGenderAndTech(
            @Param("gender")String gender,
            @Param("tech")String tech
    ){
        return s.getStudentByGenderAndTech(gender,tech);
    }

    @GetMapping("students/cust")
    public List<Student> getStudentByNameAndTech(
            @Param("name")String name,
            @Param("tech")String tech
    ){
        return s.getStudentByNameAndTech(name,tech);
    }

    @GetMapping("students/tech/{tech}")
    public List<Student> getStudentByTech(@PathVariable("tech") String tech){
        return s.getStudentByTech(tech);
    }

    @PostMapping("students/filter")
    public List<Student> getStudentByGenAndTech(
            @Param("gender")String gender,
            @Param("tech")String tech
    ){
        return s.getStudentByGenAndTech(gender,tech);
    }

    // DTO APIs

    @GetMapping("/dto/get/{rn}")
    public StudentDto getStudentDtoByRollNo(@PathVariable("rn") int rn) {
        return s.getStudentDtoByRollNo(rn);
    }

    @PostMapping("/dto/add")
    public StudentDto addStudentUsingDto(@Valid @RequestBody StudentDto dto) {
        return s.addStudentUsingDto(dto);
    }


}
