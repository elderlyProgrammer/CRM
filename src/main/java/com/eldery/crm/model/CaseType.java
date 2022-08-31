package com.eldery.crm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "case_types")
public class CaseType extends BaseEntity{
    @Column(name = "description")
    private String description;
}
