package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

public class CaseDto {

    private String description;
    private Date startDate;
    private Date endDate;
    private Map<String, String> caseType = new HashMap<>();
    private Map<String, String> company = new HashMap<>();
    private Map<String, String> person = new HashMap<>();
    private Map<String, String> responsible = new HashMap<>();
    private String number;


}
