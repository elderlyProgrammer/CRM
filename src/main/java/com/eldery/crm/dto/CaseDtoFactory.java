package com.eldery.crm.dto;

import com.eldery.crm.model.Case;

public class CaseDtoFactory {

    public static CaseDto createDtoFromCase(Case icase) {
        CaseDto caseDto = new CaseDto();
        caseDto.setDescription(icase.getDescription());
        caseDto.setStartDate(icase.getStartDate());
        caseDto.setEndDate(icase.getEndDate());
        caseDto.setCaseType(icase.getCaseType().getSimple());
        if (icase.getCompany() != null) {
            caseDto.setCompany(icase.getCompany().getSimple());
        }
        if (icase.getPerson() != null) {
            caseDto.setPerson(icase.getPerson().getSimple());
        }
        if (icase.getResponsible() != null) {
            caseDto.setResponsible(icase.getResponsible().getSimple());
        }
        caseDto.setNumber(icase.getNumber());
        return caseDto;
    }
}
