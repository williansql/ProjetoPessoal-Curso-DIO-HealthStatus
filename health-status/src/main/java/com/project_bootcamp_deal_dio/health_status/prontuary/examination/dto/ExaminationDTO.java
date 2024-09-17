package com.project_bootcamp_deal_dio.health_status.prontuary.examination.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExaminationDTO {

    private LocalDate examinationDate;
    private String typeExamination;
    private String description;
    private String result;
    private String status;
}
