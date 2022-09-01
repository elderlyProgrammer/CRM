package com.eldery.crm.dto;

import com.eldery.crm.model.Company;

import java.util.HashMap;
import java.util.Map;

public class CompanyDtoFactory {
    public static CompanyDto createDtoFromCompany(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setAddress(company.getAddress());
        companyDto.setInn(company.getInn());
        companyDto.setKpp(company.getKpp());
        companyDto.setPhoneNumber(company.getPhoneNumber());
        company.getPersons()
                .forEach(x -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("id", x.getPerson().getId().toString());
                    map.put("person", x.getPerson().getFirstName() + " " + x.getPerson().getLastName());
                    map.put("position", x.getPosition().getDescription());
                    companyDto.getPersons().add(map);
                });
        company.getContracts()
                .forEach(x -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("id", x.getId().toString());
                    map.put("description", x.getDescription());
                    companyDto.getContracts().add(map);
                });
        company.getCases()
                .forEach(x -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("id", x.getId().toString());
                    map.put("number", x.getNumber());
                    map.put("description", x.getDescription());
                    companyDto.getCases().add(map);
                });
        return companyDto;
    }
}
