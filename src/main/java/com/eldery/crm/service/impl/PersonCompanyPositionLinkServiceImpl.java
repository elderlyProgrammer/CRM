package com.eldery.crm.service.impl;

import com.eldery.crm.model.PersonCompanyPositionLink;
import com.eldery.crm.repository.PersonCompanyPositionLinkRepository;
import com.eldery.crm.service.PersonCompanyPositionLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonCompanyPositionLinkServiceImpl implements PersonCompanyPositionLinkService {
    private final PersonCompanyPositionLinkRepository repository;

    public PersonCompanyPositionLink findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        repository.deleteById(id);
    }

}
