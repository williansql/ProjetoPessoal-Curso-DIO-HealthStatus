package com.project_bootcamp_deal_dio.health_status.person.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByNameIgnoreCase(String name);

    Page<Patient> findAll(Specification<Patient> specification, Pageable pageable);
}