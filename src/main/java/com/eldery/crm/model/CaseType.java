package com.eldery.crm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "case_types")
public class CaseType extends BaseEntity{
    @Column(name = "description")
    private String description;

    public Map<String, String> getSimple() {
        Map<String, String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("description", getDescription());
        return map;
    }
}
