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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address", nullable = false)
    private String Address;

    @Column(name = "cell_phone", nullable = false)
    private String cellphone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "is_active")
    private Boolean isActive;

}