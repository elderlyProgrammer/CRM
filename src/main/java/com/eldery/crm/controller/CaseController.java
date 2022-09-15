package com.eldery.crm.controller;

import com.eldery.crm.dto.CaseDTO;
import com.eldery.crm.dto.CaseDTOFactory;
import com.eldery.crm.model.Case;
import com.eldery.crm.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping("/{id}")
    public ResponseEntity<CaseDTO> getCaseById(@PathVariable(name = "id") Long id) {
        CaseDTO caseDto = CaseDTOFactory.createDto(caseService.findCaseById(id));
        return ResponseEntity.ok(caseDto);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPage() {
        return getPageResponseEntity(0, 10);
    }

    @GetMapping("/{page}/{count}")
    public ResponseEntity<Map<String, Object>> getPage(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "count") int count) {
        return getPageResponseEntity(page - 1, count);
    }

    public void addCase (CaseDTO caseDto) {

    }

    private ResponseEntity<Map<String, Object>> getPageResponseEntity (int page, int count) {
        Page<Case> pages = caseService.getPage(page, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", pages.getTotalPages());
        map.put("page", pages.stream().map(Case::getSimple).toList());
        return ResponseEntity.ok(map);
    }

}
