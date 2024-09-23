package com.example.firstjobapp.job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
   private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
public ResponseEntity<List<Job>> findall(){
        return new ResponseEntity<>(jobService.findall(), HttpStatus.OK);
}

@PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job!=null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean bool = jobService.DeleteJobId(id);
        if (bool){
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The required Job was not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job){
       boolean bool =  jobService.updateJobByID(id, job);
       if (bool) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
       return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
