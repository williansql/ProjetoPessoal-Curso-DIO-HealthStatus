package com.project_bootcamp_deal_dio.health_status.users.user;

public enum UserRole {
    ROLE_ADMIN("admin"),
    ROLE_USER("user"),
    ROLE_COLLABORATOR("collaborator"),
    ROLE_CEO("ceo"),
    ROLE_DEVELOPER("developer"),
    ROLE_MANAGER("manager");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}