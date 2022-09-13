package com.eldery.crm.controller;

import com.eldery.crm.dto.CompanyDto;
import com.eldery.crm.dto.CompanyDtoFactory;
import com.eldery.crm.model.Company;
import com.eldery.crm.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;


    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findCompanyById(@PathVariable(name = "id") Long id) {
        Company company = companyService.findCompanyById(id);
        CompanyDto dto = CompanyDtoFactory.createDtoFromCompany(company);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{page}/{count}")
    public ResponseEntity<Map<String, Object>> getPage(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "count") int count) {

        return getPageResponseEntity(page, count);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPage() {
        return getPageResponseEntity(1, 10);
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody CompanyDto companyDto) {
        companyService.saveFromDto(companyDto);
    }

    @GetMapping("/find/{param}")
    public ResponseEntity findCompanyByParams (@PathVariable(name = "param") String param) {
        return null;
    }


    private ResponseEntity<Map<String, Object>> getPageResponseEntity (int page, int count) {
        Page<Company> companies = companyService.getPage(page - 1, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", companies.getTotalPages());
        map.put("page", companies.stream().map(Company::getSimple).toList());
        return ResponseEntity.ok(map);
    }




}
