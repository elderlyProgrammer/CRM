package com.eldery.crm.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "cases")
@AllArgsConstructor
public class Case extends BaseEntity{
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "number")
    private String number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "case_type_id", referencedColumnName = "id")
    private CaseType caseType;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @ManyToMany(mappedBy = "cases", fetch = FetchType.EAGER)
    private Set<User> responsible;

    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("description", getDescription());
        map.put("number", getNumber());
        return map;
    }


}
