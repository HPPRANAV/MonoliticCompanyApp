package com.example.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findall();
    void createJob(Job job);
    boolean DeleteJobId(Long id);
    Job getJobById(Long id);
    boolean updateJobByID(Long id, Job job);
}
