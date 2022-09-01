package com.eldery.crm.dto;

import com.eldery.crm.model.CaseType;

public class CaseTypeDtoFactory {
    public static CaseTypeDto  createDtoFromCaseType (CaseType caseType) {
        CaseTypeDto caseTypeDto = new CaseTypeDto();
        caseTypeDto.setDescription(caseType.getDescription());
        return caseTypeDto;
    }
}
