package com.example.FirstApi.Service;

import org.springframework.stereotype.Service;

@Service
public class helloService {
    public String greeting(){
        return "hello Springboot";
    }
    public String aboutme(){
        return "about springboot";
    }
    public String lec(){
        return "Welcome to lecture";
    }
}
