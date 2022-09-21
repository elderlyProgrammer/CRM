package com.eldery.crm.service;

import com.eldery.crm.model.PersonCompanyPositionLink;

public interface PersonCompanyPositionLinkService {
    PersonCompanyPositionLink findById(Long id);

    void removeById(Long id);
}
