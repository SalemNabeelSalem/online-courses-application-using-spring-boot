package com.salemnabeel.wikicoursesapp.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/home")
    public String home() {

        return ("<h1>Welcome Home</h1>");
    }

    @GetMapping("/lecturer")
    public String lecturer() {

        return ("<h1>Welcome Lecturer</h1>");
    }

    @GetMapping("/admin")
    public String admin() {

        return ("<h1>Welcome Admin</h1>");
    }
}