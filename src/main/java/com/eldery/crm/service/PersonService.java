package com.eldery.crm.service;

import com.eldery.crm.model.Person;
import com.eldery.crm.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person findPersonById (Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    public Page<Person> getPage(int page, int count) {
        return personRepository.findAll(PageRequest.of(page, count));
    }
}
