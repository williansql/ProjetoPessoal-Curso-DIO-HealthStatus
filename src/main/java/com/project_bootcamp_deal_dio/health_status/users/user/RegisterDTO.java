package com.project_bootcamp_deal_dio.health_status.users.user;

public record RegisterDTO(String login, String password, String email, UserRole role) {}