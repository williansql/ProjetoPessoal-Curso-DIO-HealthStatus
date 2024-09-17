package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@Service
public class ExaminationCriteria {

    private String typeExamination;
    private LocalDate examinationDate;
    private String status;

    public Specification<Examination> createSpecification(ExaminationCriteria criteria){
        Specification<Examination> specification = Specification.where(null);
        if(criteria.getTypeExamination() != null){
            specification = specification.and(searchTypeExamination(criteria.getTypeExamination()));
        }
        if(criteria.getExaminationDate() != null){
            specification = specification.and(searchExaminationDate(criteria.getExaminationDate()));
        }
        if(criteria.getStatus() != null){
            specification = specification.and(searchStatus(criteria.getStatus()));
        }
        return specification;
    }

    private static Specification<Examination> searchStatus(String status){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("status"), "%" + status.toLowerCase() + "%");
    }

    private static Specification<Examination> searchTypeExamination(String typeExamination){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("typeExamination"), "%" + typeExamination.toLowerCase() + "%");
    }

    private static Specification<Examination> searchExaminationDate(LocalDate examinationDate){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("examinationDate"), examinationDate);
    }
}
