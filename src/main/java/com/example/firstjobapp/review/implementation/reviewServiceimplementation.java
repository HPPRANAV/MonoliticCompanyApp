package com.example.firstjobapp.review.implementation;


import com.example.firstjobapp.company.company;
import com.example.firstjobapp.company.companyService;
import com.example.firstjobapp.review.review;
import com.example.firstjobapp.review.reviewRepository;
import com.example.firstjobapp.review.reviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class reviewServiceimplementation implements reviewService {
    private final reviewRepository reviewRepository;
    private final companyService companyService;

    public reviewServiceimplementation(reviewRepository reviewRepository, companyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);


    }

    @Override
    public boolean addReview(Long companyId, review review) {
        company company = companyService.getcompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public review getReview(Long companyId, Long reviewId) {
        List<review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId()==(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, review review) {
         if (companyService.getcompanyById(companyId) != null){
             review.setCompany(companyService.getcompanyById(companyId));
             review.setId(reviewId);
             reviewRepository.save(review);
             return true;
         }
         return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getcompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            review review = reviewRepository.findById(reviewId).orElse(null);
            company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.Updatecompanies(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
