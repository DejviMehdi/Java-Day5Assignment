package com.example.springboot.day4assignment.Entities;

import java.time.LocalDateTime;

public class Base {
    private LocalDateTime createdAt;
    private String createdBy;

    public Base() {

    }

    public Base(LocalDateTime createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}