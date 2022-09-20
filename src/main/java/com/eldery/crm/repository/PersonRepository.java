package com.eldery.crm.repository;

import com.eldery.crm.model.Contract;
import com.eldery.crm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long > {

    List<Person> findByFirstNameContainingOrFirstNameContainsIgnoreCase(String param1, String param2);
    List<Person> findByLastNameContainingOrLastNameContainsIgnoreCase(String param1, String param2);
}
