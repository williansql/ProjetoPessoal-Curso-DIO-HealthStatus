package com.project_bootcamp_deal_dio.health_status.users.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginIgnoreCase(String login);

    UserDetails findByLogin(String login);

    User findUserByLogin(String login);
}