package com.eldery.crm.service;

import com.eldery.crm.dto.ContractRDTO;
import com.eldery.crm.model.Contract;
import org.springframework.data.domain.Page;

import java.util.Collection;


public interface ContractService {
    Contract findContractById(Long id);

    Page<Contract> getPage(int page, int count);

    void addPersonToContract(Long contractId, Long personId);

    void addCompanyToContract(Long contractId, Long companyId);

    void addResponsibleToContract(Long contractId, Long responsibleId);

    void createContract(ContractRDTO contractRDTO);

    long count();

    void save(Contract contract);

    void save(Collection<Contract> contracts);
}
