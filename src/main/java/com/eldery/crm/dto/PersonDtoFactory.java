package com.eldery.crm.dto;

import com.eldery.crm.model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonDtoFactory {
    public static PersonDto createDtoFromPerson(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPhoneNumber(person.getPhoneNumber());
        personDto.setEmail(person.getEmail());
        person.getCompanies().forEach(x -> {
            Map<String,String> map = new HashMap<>();
            map.put("id", x.getCompany().getId().toString());
            map.put("company", x.getCompany().getName());
            map.put("position", x.getPosition().getDescription());
            personDto.getCompanies().add(map);
        });
        person.getCases().forEach(x -> {
            Map<String,String> map = new HashMap<>();
            map.put("id", x.getId().toString());
            map.put("description", x.getDescription());
            personDto.getCases().add(map);
        });
        person.getContracts().forEach(x -> {
            Map<String,String> map = new HashMap<>();
            map.put("id",x.getId().toString());
            map.put("number", x.getNumber());
            map.put("description", x.getDescription());
            personDto.getContracts().add(map);
        });
        return personDto;
    }
}
