package com.eldery.crm.dto;

import com.eldery.crm.model.Case;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;

import java.util.stream.Collectors;


public class CaseDTOFactory {
    public static CaseDTO createDto(Case icase) {
        CaseDTO caseDto = new CaseDTO();
        caseDto.setDescription(icase.getDescription());
        caseDto.setStartDate(icase.getStartDate());
        caseDto.setEndDate(icase.getEndDate());
        caseDto.setNumber(icase.getNumber());
        caseDto.setCaseType(icase.getCaseType().getSimple());
        caseDto.setId(icase.getId());
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

//    public static Case createCase(CaseRDTO caseRDTO) {
//        return Case.builder()
//                .description(caseRDTO.getDescription())
//                .number(caseRDTO.getNumber())
//                .startDate(caseRDTO.getStartDate())
//                .endDate(caseRDTO.getEndDate())
//                .build();
//    }

}
