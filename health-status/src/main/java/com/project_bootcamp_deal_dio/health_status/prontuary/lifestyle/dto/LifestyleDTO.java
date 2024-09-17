package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LifestyleDTO {

    private String eatingHabits;
    private String physicalActivity;
    private Boolean smoker;
    private Boolean status = true;
}
