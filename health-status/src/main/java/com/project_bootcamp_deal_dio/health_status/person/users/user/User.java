package com.project_bootcamp_deal_dio.health_status.person.users.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users", schema = "person")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private String email;
    private UserRole role;

    public User(String login, String password, String email, UserRole role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else if (this.role == UserRole.ROLE_CEO) return List.of(new SimpleGrantedAuthority("ROLE_CEO"));
        else if (this.role == UserRole.ROLE_MANAGER) return List.of(new SimpleGrantedAuthority("ROLE[_MANAGER "));
        else if (this.role == UserRole.ROLE_COLLABORATOR) return List.of(new SimpleGrantedAuthority("ROLE_COLLABORATOR"));
        else if (this.role == UserRole.ROLE_DEVELOPER) return List.of(new SimpleGrantedAuthority("ROLE_DEVELOPER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}