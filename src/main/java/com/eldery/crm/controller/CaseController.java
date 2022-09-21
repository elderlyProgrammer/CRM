package com.eldery.crm.controller;

import com.eldery.crm.dto.CaseDTO;
import com.eldery.crm.dto.CaseDTOFactory;
import com.eldery.crm.model.Case;
import com.eldery.crm.service.impl.CaseServiceImpl;
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

    private final CaseServiceImpl caseServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<CaseDTO> getCaseById(@PathVariable(name = "id") Long id) {
        CaseDTO caseDto = CaseDTOFactory.createDto(caseServiceImpl.findCaseById(id));
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

    @PostMapping("/addcompany")
    public void addCompany(@RequestBody Map<String, String> allParams) {

        caseServiceImpl.addCompanyToCase(Long.parseLong(allParams.get("case")), Long.parseLong(allParams.get("company")));

    }

    @PostMapping("/addperson")
    public void addPerson(@RequestBody Map<String, String> allParams) {

        caseServiceImpl.addPersonToCase(Long.parseLong(allParams.get("case")), Long.parseLong(allParams.get("person")));

    }

    @PostMapping("/addresponsible")
    public void addResponsible(@RequestBody Map<String, String> allParams) {
        caseServiceImpl.addResponsibleToCase(Long.parseLong(allParams.get("case")), Long.parseLong(allParams.get("responsible")));
    }



    private ResponseEntity<Map<String, Object>> getPageResponseEntity (int page, int count) {
        Page<Case> pages = caseServiceImpl.getPage(page, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", pages.getTotalPages());
        map.put("page", pages.stream().map(Case::getSimple).toList());
        return ResponseEntity.ok(map);
    }


}
