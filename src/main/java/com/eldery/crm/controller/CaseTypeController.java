package com.eldery.crm.controller;

import com.eldery.crm.model.CaseType;
import com.eldery.crm.service.CaseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/casetypes")
@RequiredArgsConstructor
public class CaseTypeController {
    private final CaseTypeService caseTypeService;

    @GetMapping("")
    public ResponseEntity<List<Map<String, String>>> getCaseTypes() {
        List<Map<String, String>> caseTypes;
        caseTypes = caseTypeService.findAll().stream()
                .map(CaseType::getSimple)
                .toList();
        return ResponseEntity.ok(caseTypes);
    }
}
