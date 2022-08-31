package com.eldery.crm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.crypto.Data;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cases")
public class Case extends BaseEntity{
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Data startDate;
    @Column(name = "end_date")
    private Data endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "case_type_id", referencedColumnName = "id")
    private CaseType caseType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User responsible;

}
