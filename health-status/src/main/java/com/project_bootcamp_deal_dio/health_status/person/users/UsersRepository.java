package com.project_bootcamp_deal_dio.health_status.person.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    UserDetails findByLogin(String login);

    Users existsByLogin(String login);

}