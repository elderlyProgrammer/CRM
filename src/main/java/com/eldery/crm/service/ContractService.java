package com.eldery.crm.service;

import com.eldery.crm.model.Contract;
import com.eldery.crm.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;

    public Contract findContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }
}
