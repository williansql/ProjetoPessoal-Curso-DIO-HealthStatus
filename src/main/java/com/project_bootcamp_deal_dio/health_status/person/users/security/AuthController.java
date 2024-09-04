package com.project_bootcamp_deal_dio.health_status.person.users.security;

import com.project_bootcamp_deal_dio.health_status.person.users.Users;
import com.project_bootcamp_deal_dio.health_status.person.users.UsersRepository;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, Object>>> login(@RequestBody @Valid AuthenticationDTO data){
        ApiResponse<Map<String, Object>> response = new ApiResponse<>();
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());
        Map<String, Object> map = new HashMap<>();
        map.put("user", auth.getPrincipal());
        map.put("token", token);
        response.of(HttpStatus.CREATED, "Bem vindo " + data.login().toUpperCase(), map);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Users>> register(@RequestBody @Valid RegisterDTO data){
        ApiResponse<Users> response = new ApiResponse<>();
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.login(), encryptedPassword, data.role());
        this.repository.save(newUser);
        response.of(
                HttpStatus.CREATED,
                "Usuário criado com sucesso " + newUser.getLogin().toUpperCase(), newUser);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
