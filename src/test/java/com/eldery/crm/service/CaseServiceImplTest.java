package com.eldery.crm.service;

import com.eldery.crm.dto.CaseRDTO;
import com.eldery.crm.model.Person;
import com.eldery.crm.service.impl.CaseServiceImpl;
import com.eldery.crm.service.impl.CaseTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class CaseServiceImplTest {

    @Autowired PersonService personService;
    @Autowired
    CaseServiceImpl caseServiceImpl;
    @Autowired
    CaseTypeServiceImpl caseTypeService;

    @Ignore
    @Test
    void addPersonToCase() {
        long caseId = 6;
        long personId = 2;
        caseServiceImpl.addPersonToCase(caseId, personId);
        Person person = caseServiceImpl.findCaseById(caseId).getPersons().stream()
                .filter(x -> x.getId().equals(personId))
                .findFirst().orElse(null);
        assert person != null;
        Assertions.assertEquals(2, person.getId());

    }

    @Test
    void createCase() {

        CaseRDTO caseRDTO = new CaseRDTO();
        caseRDTO.setCaseType(1L);
        caseRDTO.setDescription("Test case from front");
        caseRDTO.setNumber("1111");
        caseRDTO.setEndDate(new Date());
        caseRDTO.setStartDate(new Date());
        caseRDTO.setCaseType(1L);
        caseRDTO.setCompanies(Set.of(1L, 2L));
        caseRDTO.setPersons(Set.of(1L, 2L));
        caseRDTO.setResponsible(Set.of(1L, 2L));

        caseServiceImpl.createCase(caseRDTO);


    }

}