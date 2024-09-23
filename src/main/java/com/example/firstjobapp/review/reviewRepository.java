package com.example.firstjobapp.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reviewRepository extends JpaRepository<review, Long> {
    List<review> findByCompanyId(Long companyId);
}
