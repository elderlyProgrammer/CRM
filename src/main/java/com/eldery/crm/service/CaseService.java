package com.eldery.crm.service;

import com.eldery.crm.model.Case;
import com.eldery.crm.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;

    public Case findCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    public Page<Case> getPage(int page, int count) {
        return caseRepository.findAll(PageRequest.of(page, count));
    }

}
