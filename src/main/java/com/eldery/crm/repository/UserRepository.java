package com.eldery.crm.repository;

import com.eldery.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User , Long> {
    User findByLogin(String login);

}
