package com.project_bootcamp_deal_dio.health_status.person.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class UsersMapper {

    private final ModelMapper modelMapper;

    public Users transformRegisterDTOToEntity(RegisterDTO registerDTO) {
        return modelMapper.map(registerDTO, Users.class);
    }

    public RegisterDTO transformEntityToRegisterDTO(Users users) {
        return modelMapper.map(users, RegisterDTO.class);
    }

    public Users TransformAuthenticationDTOToEntity(AuthenticationDTO authenticationDTO) {
        return modelMapper.map(authenticationDTO, Users.class);
    }

    public AuthenticationDTO transformEntityToAuthenticationDTO(Users users) {
        return modelMapper.map(users, AuthenticationDTO.class);
    }
}