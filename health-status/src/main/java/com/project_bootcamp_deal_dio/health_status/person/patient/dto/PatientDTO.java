package com.project_bootcamp_deal_dio.health_status.person.patient.dto;

import com.project_bootcamp_deal_dio.health_status.prontuary.examination.Examination;
import com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle.Lifestyle;
import com.project_bootcamp_deal_dio.health_status.prontuary.references.References;
import com.project_bootcamp_deal_dio.health_status.prontuary.responsible.Responsible;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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

    @NotBlank(message = "O documento não pode ficar em branco")
    @NotNull(message = "O documento não pode fica nulo")
    private String document;
    private Boolean isActive;
    private List<Examination> examinations;
    private Lifestyle lifestyle;
    private References references;
    private Responsible responsible;

}