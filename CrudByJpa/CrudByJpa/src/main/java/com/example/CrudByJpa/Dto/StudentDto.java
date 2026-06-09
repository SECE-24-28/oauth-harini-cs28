package com.example.CrudByJpa.Dto;

import lombok.Data;

@Data
public class StudentDto {
    private int rno;
    private String name;
    private String gender;
    private String tech;
    private String email;
    private int password;
}