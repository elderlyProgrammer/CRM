package com.eldery.crm.service;

import com.eldery.crm.exception.PersonNotFoundException;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.PersonCompanyPositionLink;
import com.eldery.crm.model.Position;

import com.eldery.crm.repository.CompanyRepository;
import com.eldery.crm.repository.PersonCompanyPositionLinkRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;



@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor
class CompanyServiceTest {
    @Autowired
    PersonCompanyPositionLinkRepository personCompanyPositionLinkRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyService companyService;
    @Autowired
    PersonCompanyPositionLinkService personCompanyPositionLinkService;
    @Autowired
    PersonService personService;
    @Autowired
    PositionService positionService;

    @Ignore
    @Test
    void removePersonFromCompany() {
        long personCompanyPositionLink = personCompanyPositionLinkRepository.count();

        Company company = new Company();
        Person person = new Person();
        company.setKpp(111L);
        company.setInn(2L);
        company.setName("Test company");
        company.setAddress("Address");
        PersonCompanyPositionLink link = new PersonCompanyPositionLink();
        Position position = new Position();
        position.setDescription("TEST");

        link.setPosition(position);
        link.setCompany(company);
        link.setPerson(person);
        company.getPersons().add(link);

        positionService.save(position);
        personService.save(person);
        companyService.save(company);
        personCompanyPositionLinkRepository.save(link);
        Assertions.assertEquals(personCompanyPositionLink + 1L, personCompanyPositionLinkRepository.count());

        try {
            companyService.removePersonFromCompany(company.getId(), person.getId());
        } catch (PersonNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(personCompanyPositionLink, personCompanyPositionLinkRepository.count());


    }

    @Test
    void search() {
        Assertions.assertEquals( 3, companyService.search("лег").size());
    }
}