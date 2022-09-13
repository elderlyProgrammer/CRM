package com.eldery.crm.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cases")
@Builder
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

    @ManyToMany(mappedBy = "cases",fetch = FetchType.EAGER)
    private List<Company> companies;

    @ManyToMany(mappedBy = "cases", fetch = FetchType.EAGER)
    private List<Person> persons;

    @ManyToMany(mappedBy = "cases", fetch = FetchType.EAGER)
    private List<User> responsible;

    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("description", getDescription());
        map.put("number", getNumber());
        return map;
    }

}
