package com.example.CrudByJpa.Service;

import com.example.CrudByJpa.Dto.StudentDto;
import com.example.CrudByJpa.Repository.StudentRepository;
import com.example.CrudByJpa.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository sr;

    public List<Student> getAllStudents() {
        return sr.findAll();
    }

    public void addStudent(Student std) {
        sr.save(std);
    }

    public Student getStudentByRollNo(int roll) {
        return sr.findById(roll).orElse(new Student());
    }

    public void updateStudent(Student std) {
        sr.save(std);
    }

    public void deleteAllStudents() {
        sr.deleteAll();
    }

    public void deleteStudentByRollNo(int roll) {
        sr.deleteById(roll);
    }

    public List<Student> getStudentByGenderAndTech(String gender, String tech) {
        return sr.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStudentByNameAndTech(String name, String tech) {
        return sr.findByNameAndTech(name, tech);
    }

    public List<Student> getStudentByTech(String tech) {
        return sr.findByTech(tech);
    }

    public List<Student> getStudentByGenAndTech(String gender, String tech) {
        return sr.findByGenAndTech(gender, tech);
    }

    // DTO Methods

    public StudentDto getStudentDtoByRollNo(int rn) {
        Student s = sr.findById(rn).orElseThrow();
        return convertStudentToDto(s);
    }

    public StudentDto convertStudentToDto(Student s) {
        StudentDto dto = new StudentDto();

        dto.setRno(s.getRno());
        dto.setName(s.getName());
        dto.setGender(s.getGender());
        dto.setTech(s.getTech());
        dto.setEmail(s.getEmail());
        dto.setPassword(s.getPassword());

        return dto;
    }

    public StudentDto addStudentUsingDto(@Valid StudentDto dto) {
        Student student = sr.save(convertDtoToStudent(dto));
        return convertStudentToDto(student);
    }

    public Student convertDtoToStudent(StudentDto dto) {
        Student student = new Student();
        student.setRno(dto.getRno());
        student.setName(dto.getName());
        student.setGender(dto.getGender());
        student.setTech(dto.getTech());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());

        return student;
    }
}