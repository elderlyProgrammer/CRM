package com.eldery.crm.controller;

import com.eldery.crm.dto.CompanyDto;
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
    public Company findCompanyById(@PathVariable(name = "id") Long id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping("/{page}/{count}")
    public ResponseEntity<Map<Object, Object>> getPage(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "count") int count) {

        Map<Object, Object> resp = new HashMap<>();
        if ((page == 0)&&(count==0)) count = 10;
        Page<Company> pages = companyService.getPage(page - 1, count);
        resp.put("count", pages.getTotalPages());
        resp.put("page", pages.stream().map(Company::getSimple).toList());

        return ResponseEntity.ok(resp);
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody CompanyDto company) {
        companyService.save(company);
    }




}
