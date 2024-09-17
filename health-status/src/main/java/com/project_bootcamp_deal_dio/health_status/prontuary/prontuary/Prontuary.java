package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import com.project_bootcamp_deal_dio.health_status.person.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "prontuary", schema = "prontuary")
public class Prontuary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status = true;

}
