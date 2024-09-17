package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {

    Optional<Responsible> findByNameIgnoreCase(String name);
    Optional<Responsible> findByDocument(String document);
    Optional<Responsible> findByEmail(String email);

    Page<Responsible> findAll(Specification<Responsible> specification, Pageable pageable);
}
