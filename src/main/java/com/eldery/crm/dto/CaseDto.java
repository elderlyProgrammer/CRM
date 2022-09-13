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

public class CaseDto {

    private String description;
    private Date startDate;
    private Date endDate;
    private String number;
    private Map<String, String> caseType = new HashMap<>();
    private List<Map<String, String>> companies;
    private List<Map<String, String>> persons;
    private List<Map<String, String>> responsible;



}
