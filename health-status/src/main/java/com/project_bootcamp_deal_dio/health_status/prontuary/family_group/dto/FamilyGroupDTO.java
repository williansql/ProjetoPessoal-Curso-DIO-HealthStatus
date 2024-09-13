package com.project_bootcamp_deal_dio.health_status.prontuary.family_group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyGroupDTO {

    private Long id;
    private String responsibleName;
    private String responsibleEmail;
    private String responsibleDocument;
    private String responsiblePhone;
    private String responsibleAddress;
    private String relationship;
    private Boolean status = true;
}
