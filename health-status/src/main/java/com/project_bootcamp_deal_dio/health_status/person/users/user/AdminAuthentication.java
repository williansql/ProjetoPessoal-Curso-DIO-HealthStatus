package com.project_bootcamp_deal_dio.health_status.person.users.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAuthentication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByLoginIgnoreCase("health.admin").isEmpty()) {
            User user = new User();
            user.setId(1L);
            user.setLogin("health.admin");
            user.setEmail("willslipknotsp@gmail.com");
            user.setPassword("$2a$12$01LyHzd4bSL5RcQk1Yh.wOgMOHjS4/LdFrcv.5PnwfNGrMtVfacCO");
            user.setRole(UserRole.ROLE_ADMIN);
            user.setProntuaryList(null);
            userRepository.save(user);
        }
    }
}
