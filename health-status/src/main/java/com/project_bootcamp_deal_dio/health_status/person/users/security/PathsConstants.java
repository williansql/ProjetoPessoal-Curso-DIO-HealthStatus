package com.project_bootcamp_deal_dio.health_status.person.users.security;

public class PathsConstants {

    public static final String[] publicPaths = {
            "/auth/**"
    };
    public static final String[] permissionPaths = {
            "/patient/**",
            "/responsible/**",
            "/references/**",
            "/lifestyle/**",
    };

    public static final String[] managerPaths = {
            "/prontuary",
            "medical_examination/**"
    };

    public static final String[] colaboratorPaths = {
            "/patient/update",
            "/patient/create",
            "/patient/list"
    };

    public static final String[] fullControlPath = {
            "/user/update",
            "/user/delete"
    };

}