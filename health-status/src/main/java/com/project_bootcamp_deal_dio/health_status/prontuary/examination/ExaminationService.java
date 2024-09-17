package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import com.project_bootcamp_deal_dio.health_status.utils.models.Pagination;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService {

    ExaminationRepository repository;
    ExaminationCriteria criteria;

    public ExaminationService(
            ExaminationRepository repository,
            ExaminationCriteria criteria) {
        this.repository = repository;
        this.criteria = criteria;
    }


    public Examination create(Examination examination) {
        return repository.save(examination);
    }

    public PaginatedData<Examination> findAll(Pageable pageable, ExaminationCriteria criteria) {
        Specification<Examination> specification = criteria.createSpecification(criteria);
        Page<Examination> data = repository.findAll(specification, pageable);
        return new PaginatedData<>(data.getContent(), Pagination.from(data, pageable));
    }

    public Examination findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new BadRequestExceptions("Exame não encontrado"));
    }

    public Examination update(Long id, Examination examination) {
        Examination data = findById(id);
        BeanUtils.copyProperties(examination, data, "id");
        return repository.save(data);
    }

    public Examination changeStatus(Long id) {
        Examination data = findById(id);
        data.setStatus(data.getStatus());
        return repository.save(data);
    }
}
