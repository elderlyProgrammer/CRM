package com.eldery.crm.dto;

import com.eldery.crm.model.Case;
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
        caseDto.setCompany(icase.getSimple());
        caseDto.setPerson(icase.getSimple());
        if (icase.getResponsible() != null) {
            caseDto.setResponsible(icase.getResponsible().stream()
            .map(User::getSimple)
            .collect(Collectors.toList()));
        }

        return caseDto;
    }


}
