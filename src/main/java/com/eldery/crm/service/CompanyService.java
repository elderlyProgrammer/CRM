package com.eldery.crm.service;

import com.eldery.crm.model.Company;
import com.eldery.crm.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Long id) {
        return companyRepository
                .findById(id)
                .orElse(null);
    }
}
