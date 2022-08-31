package com.eldery.crm.dto;

import com.eldery.crm.model.CaseType;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.xml.crypto.Data;

@Getter
@Setter
@NoArgsConstructor

public class CaseDto {

    private String description;
    private Data startDate;
    private Data endDate;
    private CaseType caseType;
    private Company company;
    private Person person;
    private User responsible;


}
