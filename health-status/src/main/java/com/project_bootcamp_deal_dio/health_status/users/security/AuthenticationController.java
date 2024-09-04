package com.project_bootcamp_deal_dio.health_status.users.security;

import com.project_bootcamp_deal_dio.health_status.users.user.*;
import com.project_bootcamp_deal_dio.health_status.utils.exception.BadRequestException;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity<ApiResponse<User>> login(@RequestBody @Valid AuthenticationDTO authentication) {
        ApiResponse<User> response = new ApiResponse<>();
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authentication.login(), authentication.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        User user = userRepository.findUserByLogin(authentication.login());
        response.of(HttpStatus.OK, "Login realizado com sucesso!", user, token);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<User>> register(@RequestBody @Valid RegisterDTO user) {
        ApiResponse<User> response = new ApiResponse<>();
        Optional<User> userExists = userRepository.findByLoginIgnoreCase(user.login());
        if (userExists.isPresent()) {
            throw new BadRequestException("Esse usuário já existe em nossa base de dados");
        } else if (user.login() == null){
            throw new BadRequestException("Por favor reencha a campo do login");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        User newUser = new User(user.login(), encryptedPassword, user.email(), user.role());
        userRepository.save(newUser);
        response.of(HttpStatus.OK, "Conta criada com sucesso!", newUser);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


}