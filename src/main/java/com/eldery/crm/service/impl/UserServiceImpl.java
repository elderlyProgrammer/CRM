package com.eldery.crm.service.impl;

import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;
import com.eldery.crm.repository.UserRepository;
import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void save (User user) {
        userRepository.save(user);
    }

    public void save (Set<User> responsibles) {
        userRepository.saveAll(responsibles);
    }

    public User findUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Set<User> findAllResponsibles (Set<Long> ids) {
        return new HashSet<>(userRepository.findAllById(ids));
    }

    public List<User> search(String param) {
        List<User> byFirstname = userRepository.findByFirstNameContainingOrFirstNameContainsIgnoreCase(param, param);
        List<User> byLastname = userRepository.findByLastNameContainingOrLastNameContainsIgnoreCase(param, param);
        byFirstname.addAll(byLastname);
        return byFirstname.stream().distinct().collect(Collectors.toList());
    }


}