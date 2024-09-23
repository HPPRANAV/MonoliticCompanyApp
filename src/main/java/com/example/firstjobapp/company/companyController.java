package com.example.firstjobapp.company;


import com.example.firstjobapp.review.review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class companyController {
    private companyService companyService;

    public companyController(companyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<company> getCompanies() {
        return companyService.getAllcompanies();
    }

    @PostMapping
    public ResponseEntity<String>AddCompany(@RequestBody company company) {
        companyService.createcompany(company);
        return new ResponseEntity<>("Company created", HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateCompanyById(@PathVariable Long id, @RequestBody company company) {
        boolean bool = companyService.Updatecompanies(id, company);
        if (bool) {
            return new ResponseEntity<>("The Details on the company was Updated successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("The given company does not exist", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteCompanyById(@PathVariable Long id){
        boolean bool = companyService.deletecompanies(id);
        if (bool) {
            return new ResponseEntity<>("The Details on the company was deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The given company does not exist", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<company> getCompanyById(@PathVariable Long id){
        return new ResponseEntity<>(companyService.getcompanyById(id), HttpStatus.OK);
    }


}
