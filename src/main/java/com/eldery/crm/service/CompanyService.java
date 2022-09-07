package com.eldery.crm.service;

import com.eldery.crm.dto.CompanyDto;
import com.eldery.crm.exception.PersonNotFoundException;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.CompanyFactory;
import com.eldery.crm.model.PersonCompanyPositionLink;
import com.eldery.crm.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final PersonCompanyPositionLinkService personCompanyPositionLinkService;


    public Company findCompanyById(Long id) {
        return companyRepository
                .findById(id)
                .orElse(null);
    }

    public Page<Company> getPage(int page, int count) {
        return companyRepository.findAll(PageRequest.of(page, count));
    }

    public void save(CompanyDto companyDto) {
        companyRepository.saveAndFlush(CompanyFactory.createCompanyFromDto(companyDto));
    }

    public void save(Company company) {
        companyRepository.saveAndFlush(company);
    }

    public boolean removePersonFromCompany(Long companyId, Long personId) throws PersonNotFoundException {

        Company company = findCompanyById(companyId);
        PersonCompanyPositionLink link = company.getPersons().stream()
                .filter( x -> x.getPerson().getId().equals(personId))
                .findFirst().orElse(null);
        company.getPersons().remove(link);
        personCompanyPositionLinkService.removeById(link.getId());

        return true;
    }


}
