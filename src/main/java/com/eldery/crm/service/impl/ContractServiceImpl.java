package com.eldery.crm.service.impl;


import com.eldery.crm.dto.ContractRDTO;
import com.eldery.crm.model.*;
import com.eldery.crm.repository.ContractRepository;
import com.eldery.crm.service.CompanyService;
import com.eldery.crm.service.ContractService;
import com.eldery.crm.service.PersonService;
import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final PersonService personService;
    private final CompanyService companyService;
    private final UserService userService;

    public Contract findContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Page<Contract> getPage(int page, int count) {
        return contractRepository.findAll(PageRequest.of(page, count));
    }

    public void addPersonToContract(Long contractId, Long personId) {
        Contract contract = findContractById(contractId);
        Person person = personService.findPersonById(personId);
        contract.setPerson(person);
        person.getContracts().add(contract);
        contractRepository.save(contract);
        personService.save(person);
    }

    public void addCompanyToContract(Long contractId, Long companyId) {
        Contract contract = findContractById(contractId);
        Company company = companyService.findCompanyById(companyId);
        contract.setCompany(company);
        company.getContracts().add(contract);
        contractRepository.save(contract);
        companyService.save(company);
    }

    public void addResponsibleToContract(Long contractId, Long responsibleId) {
        Contract contract = findContractById(contractId);
        User responsible = userService.findUserById(responsibleId);
        contract.setResponsible(responsible);
        responsible.getContracts().add(contract);
        contractRepository.save(contract);
        userService.save(responsible);
    }

    public void createContract(ContractRDTO contractRDTO) {
        Person person = personService.findPersonById(contractRDTO.getPerson());
        Company company = companyService.findCompanyById(contractRDTO.getCompany());
        User responsible = userService.findUserById(contractRDTO.getResponsible());

        Contract contract = Contract.builder()
                .description(contractRDTO.getDescription())
                .number(contractRDTO.getNumber())
                .amount(contractRDTO.getAmount())
                .date(contractRDTO.getDate())
                .company(company)
                .person(person)
                .responsible(responsible)
                .build();
        contractRepository.save(contract);
        personService.save(person);
        companyService.save(company);
        userService.save(responsible);
    }

    public long count() {
        return contractRepository.count();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void save(Collection<Contract> contracts) {
        contractRepository.saveAll(contracts);
    }

}
