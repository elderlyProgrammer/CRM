package com.eldery.crm.service;

import com.eldery.crm.model.User;
import java.util.List;
import java.util.Set;

public interface UserService {
    User findByLogin(String login);

    void save(User user);

    void save(Set<User> responsibles);

    User findUserById(Long id);

    Set<User> findAllResponsibles(Set<Long> ids);

    List<User> search(String param);
}
