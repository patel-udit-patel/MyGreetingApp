package com.mygreetingsapp.service;

import com.mygreetingsapp.dto.GreetingRequest;
import com.mygreetingsapp.dto.GreetingResponse;
import com.mygreetingsapp.entity.GreetingMessage;
import com.mygreetingsapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer to handle business logic
@Service
public class GreetingService {
    @Autowired
    private final GreetingRepository greetingRepository;

    // Constructor-based Dependency Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate and Save Greeting Message
    public GreetingResponse generateAndSaveGreeting(GreetingRequest request) {
        String message;

        if (request.getFirstName() != null && request.getLastName() != null) {
            message = "Hello, " + request.getFirstName() + " " + request.getLastName() + "!";
        } else if (request.getFirstName() != null) {
            message = "Hello, " + request.getFirstName() + "!";
        } else if (request.getLastName() != null) {
            message = "Hello, " + request.getLastName() + "!";
        } else {
            message = "Hello, World!";
        }

        // Save message in the database
        GreetingMessage greetingMessage = new GreetingMessage(message);
        greetingRepository.save(greetingMessage);

        return new GreetingResponse(message,201);
    }

    // Retrieve All Saved Messages
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Create a method to find message by id
    public GreetingMessage getGreetingById(Long id) {
        return greetingRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Greeting not found for ID: " + id));
    }

    public GreetingMessage updateGreeting(Long id, String newMessage) {
        GreetingMessage greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found for ID: " + id));

        // Make a call to set the Message
        greeting.setMessage(newMessage);

        // Make a call and Save updated greeting
        return greetingRepository.save(greeting);
    }

    // Deleting the Greeting Message if id exists else throw the exception
    public void deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            // throwing the exception that id not present in the repository
            throw new RuntimeException("Greeting not found for ID: " + id);
        }
        // Make call and delete the Greeting
        greetingRepository.deleteById(id);
    }
}
