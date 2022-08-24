package com.eldery.crm.model;


import com.eldery.crm.dto.CompanyDto;

import java.time.LocalDateTime;
import java.util.Date;

public class CompanyFactory {
    public static Company createCompanyFromDto(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setInn(companyDto.getInn());
        company.setKpp(companyDto.getKpp());
        company.setPhoneNumber(companyDto.getPhoneNumber());
        company.setCreatedDate(new Date());
        company.setUpdatedDate(new Date());
        return company;
    }
}
