package com.eldery.crm.service;

import com.eldery.crm.model.User;
import com.eldery.crm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    public void saveUser (User user) {
        userRepository.save(user);
    }

}