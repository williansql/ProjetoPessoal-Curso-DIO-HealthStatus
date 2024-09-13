package com.project_bootcamp_deal_dio.health_status.person.users.security;

import com.project_bootcamp_deal_dio.health_status.person.users.user.UserRole;

public class RoleConstants {

  public static final String[] manager_roles = {
    UserRole.ROLE_MANAGER.getRole(),
    UserRole.ROLE_ADMIN.getRole(),
    UserRole.ROLE_CEO.getRole(),
  };

  public static final String[] full_control_roles = {
    UserRole.ROLE_CEO.getRole(),
    UserRole.ROLE_ADMIN.getRole()
  };

  public static final String[] collaborator_perms_roles = {
    UserRole.ROLE_COLLABORATOR.getRole(),
    UserRole.ROLE_CEO.getRole(),
    UserRole.ROLE_ADMIN.getRole(),
    UserRole.ROLE_MANAGER.getRole()
  };

  public static final String[] user_roles = {
          UserRole.ROLE_USER.getRole()
  };
}