package com.eldery.crm.service;

import com.eldery.crm.dto.CompanyDTO;
import com.eldery.crm.dto.CompanyRDTO;
import com.eldery.crm.exception.PersonNotFoundException;
import com.eldery.crm.model.Company;
import org.springframework.data.domain.Page;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CompanyService {
    Company findCompanyById(Long id);

    Page<Company> getPage(int page, int count);

    void saveFromDto(CompanyDTO companyDto);

    void save(Company company);

    void save(Collection<Company> companies);

    boolean removePersonFromCompany(Long companyId, Long personId) throws PersonNotFoundException;

    List<Company> search(String param);

    Set<Company> findAllCompanies(Collection<Long> ids);

    void createCompany(CompanyRDTO companyRDTO);
}
