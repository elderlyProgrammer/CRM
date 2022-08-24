package com.eldery.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {
    private String name;
    private Long inn;
    private Long kpp;
    private String address;
    private String phoneNumber;

}
