package com.eldery.crm.dto;

import com.eldery.crm.model.CaseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class CaseRDTO {
    private String description;
    private Date startDate;
    private Date endDate;
    private String number;
    private Long caseType;
    private Set<Long> companies = new HashSet<>();
    private Set<Long> persons = new HashSet<>();
    private Set<Long> responsible = new HashSet<>();
}
