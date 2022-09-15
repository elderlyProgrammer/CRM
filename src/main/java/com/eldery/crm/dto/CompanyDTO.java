package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    private String name;
    private Long inn;
    private Long kpp;
    private String address;
    private String phoneNumber;
    private Set<Map<String, String>> persons = new HashSet<>();
    private Set<Map<String, String>> contracts = new HashSet<>();
    private Set<Map<String, String>> cases = new HashSet<>();

}
