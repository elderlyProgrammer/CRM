package com.eldery.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "login")
    private String login;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles = new java.util.LinkedHashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_cases",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "case_id", referencedColumnName = "id")})
    private Set<Case> cases;

    @OneToMany(mappedBy = "responsible",fetch = FetchType.EAGER)
    private Set<Contract> contracts;

    public Set<String> getRoles() {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    public Map<String, String> getSimple() {
        Map<String,String> map = new HashMap<>();
        map.put("id", getId().toString());
        map.put("name", getFullName());
        return map;
    }
}