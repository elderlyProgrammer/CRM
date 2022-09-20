package com.eldery.crm.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ContractDTO extends BaseDTO {

    private String description;
    private Date date;
    private Long amount;
    private String number;

    private Set<Map<String, String>> companies = new HashSet<>();
    private Set<Map<String, String>> persons = new HashSet<>();
    private Set<Map<String, String>> responsible = new HashSet<>();

}