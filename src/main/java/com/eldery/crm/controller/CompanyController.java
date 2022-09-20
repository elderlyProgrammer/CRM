package com.eldery.crm.controller;

import com.eldery.crm.dto.CompanyDTO;
import com.eldery.crm.dto.CompanyDTOFactory;
import com.eldery.crm.model.Company;
import com.eldery.crm.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;


    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable(name = "id") Long id) {
        Company company = companyService.findCompanyById(id);
        CompanyDTO dto = CompanyDTOFactory.createDtoFromCompany(company);
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
    public void addCompany(@RequestBody CompanyDTO companyDto) {
        companyService.saveFromDto(companyDto);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Map<String, String>>> findCompanyByParams (@RequestBody Map<String, String> allParams) {
        List<Map<String, String>> list = new LinkedList<>();
        companyService.search(allParams.get("company"))
                .forEach(x -> list.add(x.getSimple()));
       return ResponseEntity.ok(list);
    }


    private ResponseEntity<Map<String, Object>> getPageResponseEntity (int page, int count) {
        Page<Company> companies = companyService.getPage(page - 1, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", companies.getTotalPages());
        map.put("page", companies.stream().map(Company::getSimple).toList());
        return ResponseEntity.ok(map);
    }




}
