package com.example.JPAdemo.Repository;

import com.example.JPAdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
