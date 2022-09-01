package com.eldery.crm.dto;

import com.eldery.crm.model.Contract;

public class ContractDtoFactory {

    public static ContractDto createDtoFromContract(Contract contract) {
        ContractDto contractDto = new ContractDto();
        contractDto.setDescription(contract.getDescription());
        contractDto.setAmount(contract.getAmount());
        contractDto.setDate(contract.getDate());
        contractDto.setNumber(contract.getNumber());
        if (contract.getCompany() != null) {
            contractDto.getCompany().add(contract.getCompany().getSimple());
        }

        if (contract.getPerson() != null) {
            contractDto.getPerson().add(contract.getPerson().getSimple());
        }
        contractDto.getResponsible().add(contract.getResponsible().getSimple());
        return contractDto;
    }
}
