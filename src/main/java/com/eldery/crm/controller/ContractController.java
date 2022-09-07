package com.eldery.crm.controller;

import com.eldery.crm.dto.ContractDto;
import com.eldery.crm.dto.ContractDtoFactory;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Contract;
import com.eldery.crm.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/{id}")
    public ResponseEntity<ContractDto> getContractById(@PathVariable(name = "id") Long id) {
        Contract contract = contractService.findContractById(id);
        return ResponseEntity.ok(ContractDtoFactory.createDtoFromContract(contract));
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

    private ResponseEntity<Map<String, Object>> getPageResponseEntity (int page, int count) {
        Page<Contract> contracts = contractService.getPage(page - 1, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", contracts.getTotalPages());
        map.put("page", contracts.stream().map(Contract::getSimple).toList());
        return ResponseEntity.ok(map);
    }
}
