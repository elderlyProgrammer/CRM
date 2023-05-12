package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;


import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Indexed
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Company extends BaseEntity{

    @Field
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

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Set<PersonCompanyPositionLink> persons = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Set<Contract> contracts = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Set<Case> cases = new HashSet<>();


    @JsonIgnore
    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("name", getName());
        return map;
    }

}
