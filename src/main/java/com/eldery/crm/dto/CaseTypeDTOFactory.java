package com.eldery.crm.dto;

import com.eldery.crm.model.CaseType;

public class CaseTypeDTOFactory {
    public static CaseTypeDTO createDtoFromCaseType (CaseType caseType) {
        CaseTypeDTO caseTypeDto = new CaseTypeDTO();
        caseTypeDto.setDescription(caseType.getDescription());
        caseTypeDto.setId(caseType.getId());
        return caseTypeDto;
    }
}
