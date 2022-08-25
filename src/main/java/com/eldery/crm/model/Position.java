package com.eldery.crm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
@NoArgsConstructor
@Getter
@Setter
public class Position extends BaseEntity{
    @Column(name = "discription")
    private String description;
}
