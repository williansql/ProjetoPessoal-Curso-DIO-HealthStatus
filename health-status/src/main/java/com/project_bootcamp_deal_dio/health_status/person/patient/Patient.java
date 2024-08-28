package com.project_bootcamp_deal_dio.health_status.person.patient;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "patient", schema = "person")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String Address;
    private String cellphone;
    private String email;
    private String document;
    private Boolean isActive;

}