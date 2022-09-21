package com.eldery.crm.service;

import com.eldery.crm.model.CaseType;

import java.util.List;

public interface CaseTypeService {

    List<CaseType> findAll();

    CaseType findById(Long id);
}
