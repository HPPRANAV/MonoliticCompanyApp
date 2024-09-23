package com.example.firstjobapp.company.implementation;
import com.example.firstjobapp.company.company;
import com.example.firstjobapp.company.companyRepository;
import com.example.firstjobapp.company.companyService;
import com.example.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImplementation implements companyService {
    private companyRepository companyrepository;

    public CompanyServiceImplementation(companyRepository companyrepository) {
        this.companyrepository = companyrepository;
    }

    @Override
    public List<company> getAllcompanies() {
        return companyrepository.findAll();

    }

    @Override
    public boolean Updatecompanies(Long id, company company) {
        Optional<company> company1 = companyrepository.findById(id);
        if(company1.isPresent()) {
            company company_1 = company1.get();
            company_1.setName(company.getName());
            company_1.setDescription(company.getDescription());
            company_1.setJobs(company.getJobs());
            companyrepository.save(company_1);
            return true;
        }
        return false;
    }

    @Override
    public void createcompany(company company) {
        companyrepository.save(company);
    }

    @Override
    public boolean deletecompanies(Long id) {
        if (companyrepository.existsById(id)) {
                companyrepository.deleteById(id);
                return true;
            }
        else {
            return false;
        }
    }

    @Override
    public company getcompanyById(Long id) {
         return companyrepository.findById(id).orElse(null);
    }

}
