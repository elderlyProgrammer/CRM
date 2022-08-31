package com.eldery.crm.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity {
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount")
    private Long amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User responsible;

}
