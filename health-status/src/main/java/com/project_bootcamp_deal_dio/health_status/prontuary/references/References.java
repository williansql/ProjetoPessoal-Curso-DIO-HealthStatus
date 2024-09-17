package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "references", schema = "prontuary")
public class References {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessName;
    private String businessPhone;
    private String businessEmail;
    private String businessRelationship;
    private Boolean status = true;
}
