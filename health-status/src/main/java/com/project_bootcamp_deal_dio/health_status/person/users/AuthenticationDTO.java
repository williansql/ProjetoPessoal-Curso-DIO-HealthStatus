package com.project_bootcamp_deal_dio.health_status.person.users;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String login;
    private String password;

}