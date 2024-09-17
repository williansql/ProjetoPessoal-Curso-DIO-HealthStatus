package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "examination", schema = "prontuary")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate examinationDate;
    private String typeExamination;

    @Column(name = "description", length = 3000)
    private String description;
    private String result;
    private String status;

}
