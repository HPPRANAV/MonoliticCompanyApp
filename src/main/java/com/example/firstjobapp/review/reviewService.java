package com.example.firstjobapp.review;


import org.springframework.stereotype.Service;

import java.util.List;


public interface reviewService {
    List<review> getReviews(Long companyId);
    boolean addReview(Long companyId,review review);
    review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,review review);
    boolean deleteReview(Long companyId,Long reviewId);

}
