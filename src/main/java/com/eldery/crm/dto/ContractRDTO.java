package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ContractRDTO {
    private String description;
    private Date date;
    private Long amount;
    private String number;

    private Set<Long> companies = new HashSet<>();
    private Set<Long> persons = new HashSet<>();
    private Set<Long> responsible = new HashSet<>();
}
