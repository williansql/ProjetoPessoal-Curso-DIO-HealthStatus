package com.project_bootcamp_deal_dio.health_status.person.users;

import jakarta.persistence.Enumerated;

public enum UsersRoleEnum {

    ADMIN("ADMIN"),
    USER("USER"),
    COLLABORATOR("COLLABORATOR");

    private String role;

    UsersRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}