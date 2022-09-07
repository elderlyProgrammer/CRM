package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "person_company_position")
@NoArgsConstructor
@Setter
@Getter
public class PersonCompanyPositionLink extends BaseEntity {
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id")
    private Person person;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "position_id")
    private Position position;

    public Person getPerson() {
        return person != null ? person : new Person();
    }

    public Company getCompany() {
        return company != null ? company : new Company();
    }

    public Position getPosition() {
        return position != null ? position : new Position();
    }
}
