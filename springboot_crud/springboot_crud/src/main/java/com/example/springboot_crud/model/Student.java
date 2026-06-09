package com.example.springboot_crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //parameterised constructor
@NoArgsConstructor // default constructor
public class Student {
    private int rno;
    private String name;
    private String tech;

    /*public Student(int rno, String name, String tech) {
        this.rno = rno;
        this.name = name;
        this.tech = tech;
    }

    public Student() {
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    } */
}
