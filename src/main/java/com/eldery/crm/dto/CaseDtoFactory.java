package com.eldery.crm.dto;

import com.eldery.crm.model.Case;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;

import java.util.stream.Collectors;


public class CaseDtoFactory {
    public static CaseDto createDto(Case icase) {
        CaseDto caseDto = new CaseDto();
        caseDto.setDescription(icase.getDescription());
        caseDto.setStartDate(icase.getStartDate());
        caseDto.setEndDate(icase.getEndDate());
        caseDto.setNumber(icase.getNumber());
        caseDto.setCaseType(icase.getCaseType().getSimple());
        if (icase.getCompanies() != null) {
            caseDto.setCompanies(icase.getCompanies().stream()
                    .map(Company::getSimple)
                    .collect(Collectors.toList()));
        }
        if (icase.getPersons() != null) {
            caseDto.setPersons(icase.getPersons().stream()
            .map(Person::getSimple)
            .collect(Collectors.toList()));
        }
        if (icase.getResponsible() != null) {
            caseDto.setResponsible(icase.getResponsible().stream()
            .map(User::getSimple)
            .collect(Collectors.toList()));
        }

        return caseDto;
    }

}
