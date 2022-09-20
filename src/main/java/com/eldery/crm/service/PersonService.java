package com.eldery.crm.service;

import com.eldery.crm.dto.PersonDto;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    public Page<Person> getPage(int page, int count) {
        return personRepository.findAll(PageRequest.of(page, count));
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void save(Set<Person> persons) {
        persons.forEach(this::save);
    }


    public long count() {
        return personRepository.count();
    }

    public void saveFromDto(PersonDto personDto) {
        Person person = Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .phoneNumber(personDto.getPhoneNumber())
                .build();
        save(person);
    }

    public List<Person> search(String param) {
        List<Person> byFirstname = personRepository.findByFirstNameContainingOrFirstNameContainsIgnoreCase(param, param);
        List<Person> byLastname = personRepository.findByLastNameContainingOrLastNameContainsIgnoreCase(param, param);
        byFirstname.addAll(byLastname);
        return byFirstname.stream().distinct().collect(Collectors.toList());
    }

    public Set<Person> findAllPersons(Set<Long> ids) {
        return new HashSet<>(personRepository.findAllById(ids));
    }
}
