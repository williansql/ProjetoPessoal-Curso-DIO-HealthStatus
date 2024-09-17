package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {
    Page<Examination> findAll(Specification<Examination> specification, Pageable pageable);
}
