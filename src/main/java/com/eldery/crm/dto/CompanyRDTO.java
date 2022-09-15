package com.eldery.crm.dto;

import java.util.HashSet;
import java.util.Set;

public class CompanyRDTO {
    private String name;
    private Long inn;
    private Long kpp;
    private String address;
    private String phoneNumber;
    private Set<Long> persons = new HashSet<>();
    private Set<Long> contracts = new HashSet<>();
    private Set<Long> cases = new HashSet<>();
}
