package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "responsible", schema = "prontuary")
@Getter
@Setter
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String document;
    private String email;
    private String address;
    private String phone;
    private String relationship;
    private Boolean status = true;
}
