package com.eldery.crm.service;

import com.eldery.crm.model.Person;
import lombok.RequiredArgsConstructor;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest
class PersonServiceTest {

    @Autowired PersonService personService;
    @Test
    @Ignore
    void search() {
        List<Person> list = personService.search("АШ");
        assertEquals(list.size(), 2);
        list = personService.search("саша");
        assertEquals(list.size(), 1);
    }
}