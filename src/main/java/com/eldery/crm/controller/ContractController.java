package com.eldery.crm.controller;

import com.eldery.crm.dto.ContractDto;
import com.eldery.crm.dto.ContractDtoFactory;
import com.eldery.crm.model.Contract;
import com.eldery.crm.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
