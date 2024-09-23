package com.example.firstjobapp.company;

import java.util.List;

public interface companyService {
    List<company> getAllcompanies();
    boolean Updatecompanies(Long id, company company);
    void createcompany(company company);
    boolean deletecompanies(Long id);
    company getcompanyById(Long id);
}
