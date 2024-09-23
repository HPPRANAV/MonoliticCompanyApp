package com.example.firstjobapp.job.implementation;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImplementation implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    //private long nextId = 1L;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }



    @Override
    public List<Job> findall() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        jobRepository.save(job);
    }


    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean DeleteJobId(Long id) {
        if (jobRepository.existsById(id)) {
            try{
                jobRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        else{
            return false;
        }
    }
    @Override
    public boolean updateJobByID(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
            if (optionalJob.isPresent()) {
                Job job1 = optionalJob.get();
                job1.setMaxSalary(job.getMaxSalary());
                job1.setMinSalary(job.getMinSalary());
                job1.setLocation(job.getLocation());
                job1.setDescription(job.getDescription());
                job1.setTitle(job.getTitle());
                jobRepository.save(job1);
                return true;
            }
        return false;
    }
}
