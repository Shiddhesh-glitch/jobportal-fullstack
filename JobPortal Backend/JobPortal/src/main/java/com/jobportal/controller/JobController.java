package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository repo;

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return repo.save(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        job.setId(id);
        return repo.save(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        repo.deleteById(id);
    }
}