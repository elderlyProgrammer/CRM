package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<PersonCompanyPositionLink> companies;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<Contract> contracts;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<Case> cases;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @JsonIgnore
    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id",this.getId().toString());
        map.put("name", getFullName());
        return map;
    }

}
