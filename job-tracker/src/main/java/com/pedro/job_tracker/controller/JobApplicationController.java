package com.pedro.job_tracker.controller;

import com.pedro.job_tracker.model.JobApplication;
import com.pedro.job_tracker.repository.JobApplicationRepository;
import jakarta.validation.Valid;
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
    public JobApplication createJob(@Valid @RequestBody JobApplication job) {
        return repository.save(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public JobApplication updateJob(@PathVariable Long id, @Valid @RequestBody JobApplication updatedjob) {
        updatedjob.setId(id);
        return repository.save(updatedjob);
    }

    @GetMapping("/status/{status}")
    public List<JobApplication> getJobsById(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    @GetMapping("/company/{company}")
    public List<JobApplication> getJobsByCompany(@PathVariable String company){
        return repository.findByCompanyContainingIgnoreCase(company);
    }
}