package com.eldery.crm.service;

import com.eldery.crm.model.CaseType;
import com.eldery.crm.repository.CaseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseTypeService {
    private final CaseTypeRepository caseTypeRepository;

    public List<CaseType> findAll() {
        return caseTypeRepository.findAll();
    }
}
