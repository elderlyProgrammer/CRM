package com.eldery.crm.controller;

import com.eldery.crm.dto.PersonDto;
import com.eldery.crm.dto.PersonDtoFactory;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/{page}/{count}")
    public ResponseEntity<Map<String, Object>> getPage(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "count") int count) {

        return getPageResponseEntity(page, count);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPage() {
        return getPageResponseEntity(1, 10);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody PersonDto personDto) {

        personService.saveFromDto(personDto);

    }

    @PostMapping("/find")
    public ResponseEntity<List<Map<String, String>>> findPersonByParams (@RequestBody Map<String, String> allParams) {
        List<Map<String, String>> list = new LinkedList<>();
        personService.search(allParams.get("person"))
                .forEach(x -> list.add(x.getSimple()));
        return ResponseEntity.ok(list);
    }

    private ResponseEntity<Map<String, Object>> getPageResponseEntity(int page, int count) {
        Page<Person> companies = personService.getPage(page - 1, count);
        Map<String, Object> map = new HashMap<>();
        map.put("count", companies.getTotalPages());
        map.put("page", companies.stream().map(Person::getSimple).toList());
        return ResponseEntity.ok(map);
    }


}
