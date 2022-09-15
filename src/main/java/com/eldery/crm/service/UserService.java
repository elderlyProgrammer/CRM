package com.eldery.crm.service;

import com.eldery.crm.model.User;
import com.eldery.crm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void save (User user) {
        userRepository.save(user);
    }

    public User findUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

}