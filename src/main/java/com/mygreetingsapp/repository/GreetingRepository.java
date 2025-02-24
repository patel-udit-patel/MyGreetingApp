package com.mygreetingsapp.repository;

import com.mygreetingsapp.entity.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessage, Long> {
    // JpaRepository provides built-in save(), findAll(), findById(), etc.
}
