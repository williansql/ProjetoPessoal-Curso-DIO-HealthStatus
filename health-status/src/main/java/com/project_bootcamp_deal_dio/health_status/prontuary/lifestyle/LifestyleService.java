package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle;

import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import com.project_bootcamp_deal_dio.health_status.utils.models.Pagination;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class LifestyleService {

    LifestyleRepository repository;
    LifestyleCriteria criteria;
    public LifestyleService(
            LifestyleRepository repository,
            LifestyleCriteria criteria) {
        this.repository = repository;
        this.criteria = criteria;
    }

    public Lifestyle create(Lifestyle lifestyle) {
        return repository.save(lifestyle);
    }

    public PaginatedData<Lifestyle> findAll(Pageable pageable, LifestyleCriteria criteria) {
        Specification<Lifestyle> specification = criteria.createSpecification(criteria);
        Page<Lifestyle> data = repository.findAll(specification, pageable);
        return new PaginatedData<>(data.getContent(), Pagination.from(data, pageable));
    }

    public Lifestyle findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new BadRequestExceptions("Estilo de vida não encontrado"));
    }

    public Lifestyle update(Long id, Lifestyle lifestyle) {
        Lifestyle data = findById(id);
        BeanUtils.copyProperties(lifestyle, data, "id");
        return repository.save(data);
    }

    public Lifestyle changeStatus(Long id) {
        Lifestyle data = findById(id);
        data.setStatus(!data.getStatus());
        return repository.save(data);
    }
}
