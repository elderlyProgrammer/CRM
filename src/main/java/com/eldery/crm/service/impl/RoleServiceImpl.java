package com.eldery.crm.service.impl;

import com.eldery.crm.model.Role;
import com.eldery.crm.repository.RoleRepository;
import com.eldery.crm.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
