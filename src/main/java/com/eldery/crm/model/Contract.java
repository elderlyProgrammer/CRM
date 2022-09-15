package com.eldery.crm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
public class Contract extends BaseEntity {
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "number")
    private String number;

    @ManyToMany(mappedBy = "contracts", fetch = FetchType.EAGER)
    private Set<Company> companies;

    @ManyToMany(mappedBy = "contracts",fetch = FetchType.EAGER)
    private Set<Person> persons;

    @ManyToMany(mappedBy = "contracts", fetch = FetchType.EAGER)
    private Set<User> responsible;


    @JsonIgnore
    public Map<String, String> getSimple() {
        LocalDateTime localDateTime = getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Map<String, String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("description", getDescription());
        map.put("date", formatter.format(localDateTime));
        map.put("number", getNumber());
        return map;
    }
}
