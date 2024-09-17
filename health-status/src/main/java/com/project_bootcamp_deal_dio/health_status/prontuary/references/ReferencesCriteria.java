package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ReferencesCriteria {

    private String businessName;

    public Specification<References> createSpecification(ReferencesCriteria criteria){
        Specification<References> specs = Specification.where(null);
        if(criteria.getBusinessName() != null)
            specs = specs.and(searchBusinessName(criteria.getBusinessName()));
        return specs;
    }

    private static Specification<References> searchBusinessName(String businessName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("businessName"), "%" + businessName + "%");
    }
}
