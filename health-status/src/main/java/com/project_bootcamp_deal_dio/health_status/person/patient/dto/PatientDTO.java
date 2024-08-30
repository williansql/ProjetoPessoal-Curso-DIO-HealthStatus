package com.project_bootcamp_deal_dio.health_status.person.patient.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    @NotBlank(message = "O nome não pode ficar vazio")
    private String name;

    @NotBlank
    private LocalDate dateOfBirth;

    @NotBlank(message = "Selecione um gênero")
    private String gender;

    @NotBlank(message = "Insira um endereço válido")
    private String address;

    @NotBlank(message = "Insira um número de telefone")
    private String cellphone;

    @NotBlank(message = "Insira um endereço de email")
    private String email;

    @NotBlank(message = "Insira o número do seu documento")
    private String document;

    private Boolean isActive;

}