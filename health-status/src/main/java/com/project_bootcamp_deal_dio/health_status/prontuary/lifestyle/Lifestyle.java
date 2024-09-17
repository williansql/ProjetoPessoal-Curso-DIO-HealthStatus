package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lifestyle", schema = "prontuary")
public class Lifestyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eatingHabits;
    private String physicalActivity;
    private Boolean smoker;
    private Boolean status = true;
}
