package com.eldery.crm.repository;

import com.eldery.crm.model.PersonCompanyPositionLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCompanyPositionLinkRepository extends JpaRepository<PersonCompanyPositionLink, Long> {
}
