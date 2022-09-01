package com.eldery.crm.dto;

import com.eldery.crm.model.Contract;

public class ContractDtoFactory {

    public static ContractDto createDtoFromContract(Contract contract) {
        ContractDto contractDto = new ContractDto();
        contractDto.setDescription(contract.getDescription());
        contractDto.setAmount(contract.getAmount());
        contractDto.setDate(contract.getDate());
        contractDto.setNumber(contract.getNumber());
        contractDto.getCompany().put(contract.getCompany().getId(),contract.getCompany().getName());
        contractDto.getPerson().put(contract.getPerson().getId(), contract.getPerson().getFullName());
        contractDto.getResponsible().put(contract.getResponsible().getId(), contract.getResponsible().getFullName());
        return contractDto;
    }
}
