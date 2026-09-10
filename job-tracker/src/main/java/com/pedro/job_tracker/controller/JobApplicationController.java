package com.pedro.job_tracker.controller;

import com.pedro.job_tracker.model.JobApplication;
import com.pedro.job_tracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")

public class JobApplicationController {

    @Autowired

    private JobApplicationRepository repository;

    @GetMapping
    public List<JobApplication> getAllJobs() {
        return repository.findAll();
    }

    @PostMapping
    public JobApplication createJob(@RequestBody JobApplication job) {
        return repository.save(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public JobApplication updateJob(@PathVariable Long id, @RequestBody JobApplication updatedjob) {
        updatedjob.setId(id);
        return repository.save(updatedjob);
    }

}