package com.eldery.crm.repository;

import com.eldery.crm.model.Person;
import com.eldery.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User , Long> {
    User findByLogin(String login);
    List<User> findByFirstNameContainingOrFirstNameContainsIgnoreCase(String param1, String param2);
    List<User> findByLastNameContainingOrLastNameContainsIgnoreCase(String param1, String param2);
}
