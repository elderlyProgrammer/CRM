package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

public class CaseDTO extends BaseDTO {

    private String description;
    private Date startDate;
    private Date endDate;
    private String number;
    private Map<String, String> caseType = new HashMap<>();
    private Map<String, String> company;
    private Map<String, String> person;
    private List<Map<String, String>> responsible;



}
