package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@Getter
@Setter
public class FamilyGroupCriteria {

    private String responsibleName;
    private String responsibleDocument;
    private String responsibleEmail;
    private Boolean status;


    public Specification<FamilyGroup> createSpecification(FamilyGroupCriteria criteria){
        Specification<FamilyGroup> specs = Specification.where(null);
        if (criteria.getResponsibleName() != null)
            specs = specs.or(FamilyGroupCriteria.searchResponsibleName(criteria.getResponsibleName()));
        if (criteria.getResponsibleDocument() != null)
            specs = specs.or(FamilyGroupCriteria.searchResponsibleDocument(criteria.getResponsibleDocument()));
        if (criteria.getResponsibleEmail() != null)
            specs = specs.or(FamilyGroupCriteria.searchResponsibleEmail(criteria.getResponsibleEmail()));
        if (criteria.getStatus() != null)
            specs = specs.or(FamilyGroupCriteria.searchStatus(criteria.getStatus()));
        return specs;
    }


    private static Specification<FamilyGroup> searchResponsibleName(String responsibleName){
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(root.get("responsibleName"),
                        "%" + responsibleName.toLowerCase() + "%");
    }

    private static Specification<FamilyGroup> searchResponsibleDocument(String responsibleDocument){
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(
                        root.get("responsibleDocumet"),
                        "%" + responsibleDocument.toLowerCase() + "%");
    }

    private static Specification<FamilyGroup> searchResponsibleEmail(String responsibleEmail){
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(
                        root.get("responsibleEmail"),
                        "%" + responsibleEmail.toLowerCase() + "%");
    }

    private static Specification<FamilyGroup> searchStatus(Boolean status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }
}
