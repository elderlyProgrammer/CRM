package com.eldery.crm.service;

import com.eldery.crm.model.Role;
import com.eldery.crm.repository.RoleRepository;

public interface RoleService {


    Role getRoleByName(String name);
}
