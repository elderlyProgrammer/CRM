package com.eldery.crm.model;


import com.eldery.crm.dto.CompanyDTO;

import java.util.Date;

public class CompanyFactory {
    public static Company createCompanyFromDto(CompanyDTO companyDto) {
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
