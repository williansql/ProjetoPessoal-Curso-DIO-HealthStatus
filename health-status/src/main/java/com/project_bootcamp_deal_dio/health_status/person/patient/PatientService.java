package com.project_bootcamp_deal_dio.health_status.person.patient;

import com.project_bootcamp_deal_dio.health_status.utils.exception.NotFoundException;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import com.project_bootcamp_deal_dio.health_status.utils.models.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

  private final PatientRepository repository;
  private final PatientCriteria patientCriteria;

  public Patient create(Patient patient) {
    Optional<Patient> sameName = repository.findByNameIgnoreCase(patient.getName());
    if (sameName.isPresent()) {
      throw new IllegalArgumentException(
          "Esse paciente ja existe em nosso banco de dados. "
              + sameName.get().getName().toUpperCase());
    }
    patient.setIsActive(true);
    return repository.save(patient);
  }

  public PaginatedData<Patient> findAll(Pageable pageable, PatientCriteria criteria) {
    Specification<Patient> specification = patientCriteria.createSpecification(criteria);
    Page<Patient> page = repository.findAll(specification, pageable);
    return new PaginatedData<>(page.getContent(), Pagination.from(page, pageable));
  }

  public Patient findById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Paciente não encontrado."));
  }

  public Patient update(Long id, Patient patient) {
    Patient find = findById(id);
      BeanUtils.copyProperties(patient, find, "id");
    return repository.save(find);
  }

  public void delete(Long id) {
    Patient find = findById(id);
    find.setIsActive(!find.getIsActive());
    repository.save(find);
  }
}