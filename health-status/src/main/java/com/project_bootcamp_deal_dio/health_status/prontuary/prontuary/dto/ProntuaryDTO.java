package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.dto;

import com.project_bootcamp_deal_dio.health_status.person.patient.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProntuaryDTO {

    private String code;
    private Patient patient;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status = true;
}
