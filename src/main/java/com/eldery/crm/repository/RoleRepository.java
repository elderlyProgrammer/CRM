package com.eldery.crm.repository;

import com.eldery.crm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
