package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class LifestyleCriteria {

    private String eatingHabits;
    private String physicalActivity;
    private Boolean smoker;

    public Specification<Lifestyle> createSpecification(LifestyleCriteria criteria) {
        Specification<Lifestyle> specs = Specification.where(null);
        if (criteria.getEatingHabits() != null)
            specs = specs.and(searchHabits(criteria.getEatingHabits()));
        if (criteria.getPhysicalActivity() != null)
            specs = specs.and(searchPhysicalActivity(criteria.getPhysicalActivity()));
        if (criteria.getSmoker() != null)
            specs = specs.and(searchSmoker(criteria.getSmoker()));
        return specs;
    }

    private static Specification<Lifestyle> searchHabits(String eatingHabits) {
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(root.get("eatingHabits"), "%" + eatingHabits.toLowerCase() + "%");
    }

    private static Specification<Lifestyle> searchPhysicalActivity(String physicalActivity) {
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(root.get("physicalActivity"), "%" + physicalActivity.toUpperCase() + "%");
    }

    private static Specification<Lifestyle> searchSmoker(Boolean smoker) {
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.equal(root.get("smoker"), smoker);
    }
}
