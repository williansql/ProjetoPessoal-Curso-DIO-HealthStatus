package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "family_group", schema = "prontuary")
@Getter
@Setter
public class FamilyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsibleName;
    private String responsibleEmail;
    private String responsibleDocument;
    private String responsiblePhone;
    private String responsibleAddress;
    private String relationship;
    private Boolean status = true;
}
