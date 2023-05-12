package com.eldery.crm.service.impl;

import com.eldery.crm.dto.CaseRDTO;
import com.eldery.crm.model.*;
import com.eldery.crm.repository.CaseRepository;
import com.eldery.crm.service.CaseService;
import com.eldery.crm.service.CompanyService;
import com.eldery.crm.service.PersonService;
import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final PersonService personService;
    private final CompanyService companyService;
    private final UserService userService;
    private final CaseTypeServiceImpl caseTypeService;

    public Case findCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    public Page<Case> getPage(int page, int count) {
        return caseRepository.findAll(PageRequest.of(page, count));
    }

    public void addPersonToCase(Long caseId, Long personId) {
        Case icase = findCaseById(caseId);
        Person person = personService.findPersonById(personId);
        icase.setPerson(person);
        person.getCases().add(icase);
        save(icase);
        personService.save(person);
    }

    public void addCompanyToCase(Long caseId, Long companyId) {
        Case icase = findCaseById(caseId);
        Company company = companyService.findCompanyById(companyId);
        icase.setCompany(company);
        company.getCases().add(icase);
        companyService.save(company);
        save(icase);
    }

    public void addResponsibleToCase(Long icaseId, Long responsibleId) {
        Case icase = findCaseById(icaseId);
        User responsible = userService.findUserById(responsibleId);
        icase.getResponsible().add(responsible);
        responsible.getCases().add(icase);
        save(icase);
        userService.save(responsible);
    }

    public void createCase(CaseRDTO caseRDTO) {

        CaseType caseType = caseTypeService.findById(caseRDTO.getCaseType());
        Person person = personService.findPersonById(caseRDTO.getPerson());
        Company company = companyService.findCompanyById(caseRDTO.getCompany());
        Set<User> responsibles = userService.findAllResponsibles(caseRDTO.getResponsibles());

        Case newCase = Case.builder()
                .number(caseRDTO.getNumber())
                .description(caseRDTO.getDescription())
                .startDate(caseRDTO.getStartDate())
                .endDate(caseRDTO.getEndDate())
                .caseType(caseType)
                .person(person)
                .company(company)
                .responsible(responsibles)
                .build();
        save(newCase);

        personService.save(person);
        companyService.save(company);
        userService.save(responsibles);

    }

    public long count() {
        return caseRepository.count();
    }

    public void save(Case icase) {
        caseRepository.save(icase);
    }

    public void save(Collection<Case> caseCollection) {
        caseRepository.saveAll(caseCollection);
    }
}
