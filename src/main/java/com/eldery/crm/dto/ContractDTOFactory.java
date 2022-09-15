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
        if (contract.getCompanies() != null) {
            contractDto.setCompanies(contract.getCompanies().stream()
            .map(Company::getSimple)
            .collect(Collectors.toSet()));
        }

        if (contract.getPersons() != null) {
            contractDto.setPersons(contract.getPersons().stream()
            .map(Person::getSimple)
            .collect(Collectors.toSet()));
        }
        if (contract.getResponsible() != null) {
            contractDto.setResponsible(contract.getResponsible().stream()
            .map(User::getSimple)
            .collect(Collectors.toSet()));
        }
        return contractDto;
    }
}
