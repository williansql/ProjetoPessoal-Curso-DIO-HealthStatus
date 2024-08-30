package com.project_bootcamp_deal_dio.health_status.person.users.security;

import com.project_bootcamp_deal_dio.health_status.person.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        return usersRepository.findByLogin(login);
    }
}