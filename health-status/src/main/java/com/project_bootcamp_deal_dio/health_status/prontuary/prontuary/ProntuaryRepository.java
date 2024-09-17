package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuaryRepository extends JpaRepository<Prontuary, Long> {
    Page<Prontuary> findAll(Specification<Prontuary> specification, Pageable pageable);
}
