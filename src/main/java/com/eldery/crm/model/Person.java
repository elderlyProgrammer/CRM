package com.eldery.crm.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
@Getter
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<PersonCompanyPositionLink> companies;

}
