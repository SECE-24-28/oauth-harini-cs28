package com.example.springboot_crud.service;

import com.example.springboot_crud.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Harini","Springboot"),
            new Student(2,"Yuvashree","React")
    ));
    public List<Student> getAllStudent() {
        return students;
    }

    public Student getStudentByRollNo(int roll) {
        int index = 0;
        boolean flag = true;
        for(int i = 0; i < students.size();i++){
            if(students.get(i).getRno() == roll){
                index = i;
                flag = false;
            }
        }
        if(flag) return new Student(0,"","");
        else{
            return students.get(index);
        }
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public String updateStudent(Student std) {
        int index = 0;
        boolean flag = true;
        for(int i = 0; i < students.size();i++){
            if(students.get(i).getRno() == std.getRno()){
                index = i;
                flag = false;
                break;
            }
        }
        if(flag) return "No such data";
        else {
            students.set(index, std);
            return "Updated";
        }
    }

    public String deleteStudent(int r) {
        int index = 0;
        boolean flag = true;
        for(int i = 0; i < students.size();i++){
            if(students.get(i).getRno() == r){
                index = i;
                flag = false;
                break;
            }
        }
        if(flag) return "No such data";
        else{
            students.remove(index);
            return "deleted successfully";
        }
    }
}
