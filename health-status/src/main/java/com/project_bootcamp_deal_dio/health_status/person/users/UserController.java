package com.project_bootcamp_deal_dio.health_status.person.users;

import com.project_bootcamp_deal_dio.health_status.person.users.security.TokenService;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UsersRepository usersRepository;
  @Autowired
  private TokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity<ApiResponse<Users>> register(@RequestBody @Valid RegisterDTO registerDTO) {
    if(this.usersRepository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
    Users newUser = new Users(registerDTO.login(), encryptedPassword, registerDTO.role());

    this.usersRepository.save(newUser);

    return ResponseEntity.ok().build();
  }
}