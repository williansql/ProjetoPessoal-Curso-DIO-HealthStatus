package com.project_bootcamp_deal_dio.health_status.prontuary.responsible.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsibleDTO {

    @NotNull(message = "Campo nome não pode ficar nulo")
    @NotBlank(message = "Campo nome não pode ficar em branco")
    private String name;

    @NotNull(message = "Campo documento não pode ficar nulo")
    @NotBlank(message = "Campo documento não pode ficar em branco")
    private String document;
    private String email;

    @NotNull(message = "Campo endereço não pode ficar nulo")
    @NotBlank(message = "Campo endereço não pode ficar em branco")
    private String address;

    @NotNull(message = "Campo telefone não pode ficar nulo")
    @NotBlank(message = "Campo telefone não pode ficar em branco")
    private String phone;
    private String relationship;
    private Boolean status = true;
}
