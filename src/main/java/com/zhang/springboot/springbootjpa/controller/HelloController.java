package com.zhang.springboot.springbootjpa.controller;

import com.zhang.springboot.springbootjpa.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

    @GetMapping("/say")
    public String sayHello(String name) {
        return "hello," + name;
    }

    @GetMapping("/say2")
    public String sayHello2(String name) {
        String firstName = null;
        int code = firstName.length();
        return "hello," + name;
    }

    @GetMapping("/say3")
    public String sayHello3(String name) {
        double b = 2 / 0;
        return "hello," + name;
    }
    @GetMapping("/stu")
    public String validStudent(@Valid Student student){

        return student.toString();
    }
}
