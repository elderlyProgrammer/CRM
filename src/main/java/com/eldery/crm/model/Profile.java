package com.eldery.crm.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity{

    @Column(name = "description")
    private String description;

    public Profile() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Profile;
    }

}
