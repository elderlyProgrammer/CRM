package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "persons")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private Set<PersonCompanyPositionLink> companies = new HashSet<>();

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "persons_contracts",
//            joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "id")})
//    private Set<Contract> contracts = new HashSet<>();
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private Set<Contract> contracts = new HashSet<>();

    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
    private Set<Case> cases = new HashSet<>();

    public Person() {

    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @JsonIgnore
    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id", this.getId().toString());
        map.put("name", getFullName());
        return map;
    }


    }

