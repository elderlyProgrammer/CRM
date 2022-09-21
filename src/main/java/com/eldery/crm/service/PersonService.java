package com.eldery.crm.service;

import com.eldery.crm.dto.PersonDto;
import com.eldery.crm.model.Person;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Set;


public interface PersonService {
    Person findPersonById(Long id);

    Page<Person> getPage(int page, int count);

    void save(Person person);

    void save(Set<Person> persons);


    long count();

    void saveFromDto(PersonDto personDto);

    List<Person> search(String param);

    Set<Person> findAllPersons(Set<Long> ids);
}
