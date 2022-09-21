package com.eldery.crm.service;

import com.eldery.crm.dto.CaseRDTO;
import com.eldery.crm.model.*;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface CaseService {
    Case findCaseById(Long id);

    Page<Case> getPage(int page, int count);

    void addPersonToCase(Long caseId, Long personId);

    void addCompanyToCase(Long caseId, Long companyId);

    void addResponsibleToCase(Long icaseId, Long responsibleId);

    void createCase(CaseRDTO caseRDTO);

    long count();

    void save(Case icase);

    void save(Collection<Case> caseCollection);
}
