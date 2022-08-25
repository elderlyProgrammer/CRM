package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class PersonDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<Map<String, String>> companies = new HashSet<>();
}
