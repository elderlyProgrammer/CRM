package com.eldery.crm.service;

import com.eldery.crm.model.Contract;
import com.eldery.crm.model.Person;
import lombok.RequiredArgsConstructor;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest
class ContractServiceTest {
    @Autowired ContractService contractService;
    @Autowired PersonService personService;
    @Test
    @Ignore
    void addPersonToContract() {
        long personId = 1;
        long contractId = 1;
        contractService.addPersonToContract(contractId, personId);
        Person person = personService.findPersonById(personId);
        Contract contract = contractService.findContractById(contractId);
        Assertions.assertEquals(1, Objects.requireNonNull(contract.getPersons().stream()
                .filter(x -> x.getId().equals(personId))
                .findFirst().orElse(null)).getId());

    }
}