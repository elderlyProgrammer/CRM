package com.eldery.crm.dto;

import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ContractDto {

    private String description;
    private Date date;
    private Long amount;
    private String number;

    private Map<Long, String> company = new HashMap<>();
    private Map<Long, String> person = new HashMap<>();
    private Map<Long, String> responsible = new HashMap<>();

}
