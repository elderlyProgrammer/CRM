package com.eldery.crm.service.impl;

import com.eldery.crm.model.CaseType;
import com.eldery.crm.repository.CaseTypeRepository;
import com.eldery.crm.service.CaseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseTypeServiceImpl implements CaseTypeService {
    private final CaseTypeRepository caseTypeRepository;

    public List<CaseType> findAll() {
        return caseTypeRepository.findAll();
    }

    public CaseType findById(Long id) {
        return caseTypeRepository.findById(id).orElse(null);
    }
}
