package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company extends BaseEntity{
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

    @JsonIgnore
    public Map<Long, String> getSimple() {
        Map<Long, String> map = new HashMap<>();
        map.put(this.getId(), this.getName());
        return map;
    }

}
