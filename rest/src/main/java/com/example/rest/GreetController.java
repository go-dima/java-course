package com.example.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {
    //Usage: http://localhost:8080/greet?name=Dima
    @GetMapping("/greet")
    public String greet(@RequestParam(value="name", defaultValue="John Doe") String name) {
        return "Hello " + name;
    }
}
