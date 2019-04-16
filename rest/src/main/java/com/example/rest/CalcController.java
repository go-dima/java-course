package com.example.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    //Usage: http://localhost:8080/sum/5/6
    @RequestMapping("/sum/{num1}/{num2}")
    public int sum(@PathVariable("num1")int x,
                   @PathVariable("num2")int y) {
        return x+y;
    }
}
