package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utility.AddRequest;

@RestController
public class AdditionController {
    
    @PostMapping("/add")
    public int addNumbers(@RequestBody AddRequest request) {
        return request.getNum1() + request.getNum2();
    }
}
