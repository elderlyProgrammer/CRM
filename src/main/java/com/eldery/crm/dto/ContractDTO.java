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

    private Map<String, String> company;
    private Map<String, String> person;
    private Map<String, String> responsible;

}
