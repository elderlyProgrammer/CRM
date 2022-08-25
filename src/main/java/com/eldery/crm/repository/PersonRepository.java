package com.eldery.crm.repository;

import com.eldery.crm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long > {
}
