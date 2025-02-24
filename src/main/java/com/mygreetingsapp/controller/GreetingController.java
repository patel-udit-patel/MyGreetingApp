package com.mygreetingsapp.controller;

import com.mygreetingsapp.dto.GreetingRequest;
import com.mygreetingsapp.dto.GreetingResponse;
import com.mygreetingsapp.entity.GreetingMessage;
import com.mygreetingsapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting") // Base URL for all endpoints
public class GreetingController {

    @Autowired
    private final GreetingService greetingService;

    // Constructor to initialize greeting service (DI = dependency Injection)
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC01-Created a method to get messages using id
    @GetMapping("/{Id}")
    public GreetingMessage getGreetingById(@PathVariable Long Id) {
        return greetingService.getGreetingById(Id);
    }


}
