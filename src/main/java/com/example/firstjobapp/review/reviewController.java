package com.example.firstjobapp.review;


import com.example.firstjobapp.company.company;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class reviewController {
    private reviewService reviewService;
    public reviewController(reviewService reviewservice) {
        this.reviewService = reviewservice;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<review>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId),
                HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String>addReview(@RequestBody review review, @PathVariable Long companyId) {
            boolean bool = reviewService.addReview(companyId, review);
            if (bool) {
                return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Company Does Not Exist", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> UpdateReviewById(@PathVariable Long reviewId, @PathVariable Long companyId,
                                                   @RequestBody review review) {
        boolean bool = reviewService.updateReview(reviewId, companyId, review);
        if(bool){
            return new ResponseEntity<>("The review was updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The matching review wasn't found", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean bool = reviewService.deleteReview(companyId, reviewId);
        if(bool){
            return new ResponseEntity<>("The review was deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The matching review wasn't found", HttpStatus.NOT_FOUND);
    }

}

