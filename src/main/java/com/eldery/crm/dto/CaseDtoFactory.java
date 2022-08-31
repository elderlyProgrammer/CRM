package com.eldery.crm.dto;

import com.eldery.crm.model.Case;

public class CaseDtoFactory {

    public static CaseDto createDtoFromCase(Case icase) {
        CaseDto caseDto = new CaseDto();
        caseDto.setDescription(icase.getDescription());
        caseDto.setStartDate(icase.getStartDate());
        caseDto.setEndDate(icase.getEndDate());
        caseDto.setCompany(icase.getCompany());
        caseDto.setCaseType(icase.getCaseType());
        caseDto.setPerson(icase.getPerson());
        caseDto.setResponsible(icase.getResponsible());
        return caseDto;
    }
}
