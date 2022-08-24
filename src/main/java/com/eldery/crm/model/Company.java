package com.eldery.crm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "kpp")
    private Long kpp;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;


}
