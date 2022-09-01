package com.eldery.crm.dto;

import com.eldery.crm.model.CaseType;
import com.eldery.crm.model.Company;
import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class CaseDto {

    private String description;
    private Date startDate;
    private Date endDate;
    private CaseType caseType;
    private Company company;
    private Person person;
    private User responsible;
    private String number;


}
