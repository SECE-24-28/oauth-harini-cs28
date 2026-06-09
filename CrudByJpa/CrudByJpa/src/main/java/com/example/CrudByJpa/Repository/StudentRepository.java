package com.example.CrudByJpa.Repository;

import com.example.CrudByJpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByGenderAndTech(String gender,String tech);

    List<Student> findByNameAndTech(String name, String tech);

    List<Student> findByTech(String tech);

    @Query(nativeQuery = true, value = "SELECT * FROM Student where gender=:gender And tech=:tech")
    List<Student> findByGenAndTech(String gender, String tech);
}
