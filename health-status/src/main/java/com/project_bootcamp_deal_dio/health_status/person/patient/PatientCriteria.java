package com.project_bootcamp_deal_dio.health_status.person.patient;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Data
public class PatientCriteria {

    private String name;
    private String email;
    private String document;

    public Specification<Patient> createSpecification(PatientCriteria criteria){
        Specification<Patient> specs = Specification.where(null);
        if (criteria.getName() != null){
            specs = specs.or(PatientCriteria.searchName(criteria.getName()));
        } else if(criteria.getEmail() != null){
            specs = specs.or(PatientCriteria.serchEmail(criteria.getEmail()));
        } else if(criteria.getDocument() != null){
            specs = specs.or(PatientCriteria.searchDocument(criteria.document));
        }
        return specs;
    }

    private static Specification<Patient> searchName(String name){
        return ((root,query,criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }

    private static Specification<Patient> serchEmail(String email){
        return ((root,query,criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%"));
    }

    private static Specification<Patient> searchDocument(String document){
        return (root,query,criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("document")), "%" + document + "%");
    }
}