package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferencesRepository extends JpaRepository<References, Long> {
    Optional<References> findByBusinessNameIgnoreCase(String businessName);

    Page<References> findAll(Specification<References> specification, Pageable pageable);
}
