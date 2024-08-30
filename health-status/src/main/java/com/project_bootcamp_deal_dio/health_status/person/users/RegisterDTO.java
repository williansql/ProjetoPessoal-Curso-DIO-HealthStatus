package com.project_bootcamp_deal_dio.health_status.person.users;

public record RegisterDTO (String login, String password, UsersRoleEnum role) {}