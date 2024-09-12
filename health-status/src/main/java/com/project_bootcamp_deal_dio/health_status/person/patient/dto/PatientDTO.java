package com.project_bootcamp_deal_dio.health_status.person.patient.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    @NotBlank(message = "O nome não pode ficar vazio")
    @NotNull
    private String name;

    @NotBlank(message = "o campo DATA DE NASCIMENTO não pode ficar em branco.")
    @NotNull(message = "Por favor preencher data de nascimento.")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Selecione um gênero")
    @NotNull
    private String gender;

    @NotBlank(message = "Insira um endereço válido")
    @NotNull
    private String address;

    @NotBlank(message = "Insira um número de telefone")
    @NotNull
    private String cellphone;

    @NotBlank(message = "Insira um endereço de email")
    @NotNull
    private String email;

    @NotBlank(message = "Insira o número do seu documento")
    @NotNull
    private String document;

    private Boolean isActive;

}