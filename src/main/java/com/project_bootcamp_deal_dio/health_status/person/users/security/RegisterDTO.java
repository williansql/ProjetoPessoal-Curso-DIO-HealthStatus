package com.project_bootcamp_deal_dio.health_status.person.users.security;

import com.project_bootcamp_deal_dio.health_status.person.users.UsersRoleEnum;

public record RegisterDTO(String login, String password, UsersRoleEnum role) {
}
