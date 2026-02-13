package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.jobportal.model.Application;
import com.jobportal.repository.ApplicationRepository;

@RestController
@CrossOrigin
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository repo;

    @PostMapping
    public Application apply(@RequestBody Application app) {
        app.setStatus("APPLIED");
        return repo.save(app);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getByUser(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping
    public List<Application> getAll() {
        return repo.findAll();
    }
}