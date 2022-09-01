package com.eldery.crm.repository;

import com.eldery.crm.model.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseTypeRepository extends JpaRepository<CaseType, Long> {

}
