package com.project_bootcamp_deal_dio.health_status.person.users.user;

import com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.Prontuary;

import java.util.List;

public record RegisterDTO(String login, String password, String email, UserRole role, List<Prontuary> prontuaryList) {}