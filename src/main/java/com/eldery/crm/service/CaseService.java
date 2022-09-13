package com.eldery.crm.service;

import com.eldery.crm.dto.CaseRDTO;
import com.eldery.crm.model.*;
import com.eldery.crm.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final PersonService personService;
    private final CompanyService companyService;
    private final UserService userService;
    private final CaseTypeService caseTypeService;

    public Case findCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    public Page<Case> getPage(int page, int count) {
        return caseRepository.findAll(PageRequest.of(page, count));
    }

    public void addPersonToCase (Long caseId, Long personId) {
        Case icase = findCaseById(caseId);
        Person person = personService.findPersonById(personId);
        icase.getPersons().add(person);
        person.getCases().add(icase);
        save(icase);
        personService.save(person);
    }

    public void addCompanyToCase(Long caseId, Long companyId) {
        Case icase = findCaseById(caseId);
        Company company = companyService.findCompanyById(companyId);
        icase.getCompanies().add(company);
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

    public void createCase (CaseRDTO caseRDTO) {
        Case newCase;
        CaseType caseType = caseTypeService.findById(caseRDTO.getCaseType());
        newCase = Case.builder()
                .number(caseRDTO.getNumber())
                .description(caseRDTO.getDescription())
                .startDate(caseRDTO.getStartDate())
                .endDate(caseRDTO.getEndDate())
                .caseType(caseType)
//                .persons(new ArrayList<>())
//                .companies(new ArrayList<>())
//                .responsible(new ArrayList<>())
                .build();
        save(newCase);
    }

    public long count () {
        return caseRepository.count();
    }

    public void save(Case icase) {
        caseRepository.save(icase);
    }

}
