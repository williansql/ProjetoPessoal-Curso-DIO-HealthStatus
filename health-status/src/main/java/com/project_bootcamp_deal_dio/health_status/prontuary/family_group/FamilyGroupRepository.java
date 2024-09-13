package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilyGroupRepository extends JpaRepository<FamilyGroup, Long> {

    Optional<FamilyGroup> findByResponsibleDocument(String responsibleDocument);
    Optional<FamilyGroup> findByResponsibleNameIgnoreCase(String responsibleName);

    Optional<FamilyGroup> findByResponsibleEmailIgnoreCase(String responsibleEmail);

    Page<FamilyGroup> findAll(Pageable pageable, Specification<FamilyGroup> specification);
}
