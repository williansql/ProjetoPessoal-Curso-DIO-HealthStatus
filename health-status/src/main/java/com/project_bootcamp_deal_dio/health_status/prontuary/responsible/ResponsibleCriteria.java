package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ResponsibleCriteria {

    private String name;
    private String document;
    private String email;


    public Specification<Responsible> createSpecification(ResponsibleCriteria criteria){
        Specification<Responsible> specs = Specification.where(null);
        if (criteria.getName() != null)
            specs = specs.or(searchName(criteria.getName()));
        if (criteria.getDocument() != null)
            specs = specs.or(searchDocument(criteria.getDocument()));
        if (criteria.getEmail() != null)
            specs = specs.or(searchEmail(criteria.getEmail()));
        return specs;
    }


    private static Specification<Responsible> searchName(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    private static Specification<Responsible> searchDocument(String document){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("document"), "%" + document + "%");
    }

    private static Specification<Responsible> searchEmail(String email){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }
}
