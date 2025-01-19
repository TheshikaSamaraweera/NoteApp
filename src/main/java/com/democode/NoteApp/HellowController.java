package com.democode.NoteApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, this is a simple RESTful API for managing notes. Please use '/notes' endpoints.";
    }
    @GetMapping("/contact")
    public String contact() {
        return "otes. Please use '/contact' endpoints.";
    }

}
