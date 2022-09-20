package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class PersonDto extends BaseDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Set<Map<String, String>> companies = new HashSet<>();
    private Set<Map<String, String>> cases = new HashSet<>();
    private Set<Map<String, String>> contracts = new HashSet<>();

}
