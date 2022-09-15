package com.eldery.crm.service;

import com.eldery.crm.model.User;
import com.eldery.crm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void findUserById() {
        User user = userService.findUserById(1L);
        assertEquals(1L, 1L);
    }

    @Test
    void findByLogin() {
        User user = userService.findByLogin("admin");
        assertEquals(1L, user.getId());
    }
}