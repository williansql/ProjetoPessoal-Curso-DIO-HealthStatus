package com.project_bootcamp_deal_dio.health_status.prontuary.references.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferencesDTO {

    @NotNull(message = "Campo nome não pode ficar nulo")
    @NotBlank(message = "Campo nome não pode ficar em branco")
    private String businessName;

    private String businessPhone;
    private String businessEmail;

    @NotNull(message = "Campo de relacionamento não pode ficar nulo")
    @NotBlank(message = "Campo de relacionamento não pode ficar em branco")
    private String businessRelationship;

    private Boolean status = true;

}
