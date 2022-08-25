package com.eldery.crm.controller;

import com.eldery.crm.dto.PersonDto;
import com.eldery.crm.dto.PersonDtoFactory;
import com.eldery.crm.model.Person;
import com.eldery.crm.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable(name = "id") Long id) {
        Person person = personService.findPersonById(id);
        return ResponseEntity.ok(PersonDtoFactory.createDtoFromPerson(person));
    }

}
