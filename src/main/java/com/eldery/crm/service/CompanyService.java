package com.eldery.crm.service;

import com.eldery.crm.dto.CompanyDto;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.CompanyFactory;
import com.eldery.crm.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


    public Company findCompanyById(Long id) {
        return companyRepository
                .findById(id)
                .orElse(null);
    }

    public Page<Company> getPage(int page, int count) {
        return companyRepository.findAll(PageRequest.of(page, count));
    }

    public void save(CompanyDto companyDto) {
        companyRepository.saveAndFlush(CompanyFactory.createCompanyFromDto(companyDto));
    }


}
