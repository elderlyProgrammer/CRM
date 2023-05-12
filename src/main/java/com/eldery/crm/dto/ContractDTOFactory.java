package com.eldery.crm.dto;

import com.eldery.crm.model.Company;
import com.eldery.crm.model.Contract;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;

import java.util.stream.Collectors;

public class ContractDTOFactory {

    public static ContractDTO createDtoFromContract(Contract contract) {
        ContractDTO contractDto = new ContractDTO();
        contractDto.setDescription(contract.getDescription());
        contractDto.setAmount(contract.getAmount());
        contractDto.setDate(contract.getDate());
        contractDto.setNumber(contract.getNumber());
        contractDto.setId(contract.getId());
        contractDto.setCompany(contract.getCompany().getSimple());
        contractDto.setPerson(contract.getPerson().getSimple());
        contractDto.setResponsible(contract.getResponsible().getSimple());
        return contractDto;
    }
}
