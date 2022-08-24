package com.eldery.crm.controller;

import com.eldery.crm.model.Company;
import com.eldery.crm.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping()
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company findCompanyById(@PathVariable(name = "id") Long id) {
        return companyService.findCompanyById(id);
    }



}
