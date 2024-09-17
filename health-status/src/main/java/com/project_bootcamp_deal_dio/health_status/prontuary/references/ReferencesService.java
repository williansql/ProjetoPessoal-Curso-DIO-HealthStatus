package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
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
public class ReferencesService {

    private final ReferencesRepository repository;
    private final ReferencesCriteria criteria;

    public References create(References references) {
        Optional<References> sameName = repository.findByBusinessNameIgnoreCase(references.getBusinessName());

        if (sameName.isPresent())
            throw new BadRequestExceptions("Ja existe um contato de referência com o nome informado");
        return repository.save(references);
    }

    public PaginatedData<References> findAll(Pageable pageable, ReferencesCriteria criteria) {
        Specification<References> specification = criteria.createSpecification(criteria);
        Page<References> data = repository.findAll(specification, pageable);
        return new PaginatedData<>(data.getContent(), Pagination.from(data, pageable));
    }

    public References findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new BadRequestExceptions("Contato de referência não encontrado"));
    }

    public References update(Long id, References references) {

        Optional<References> sameName = repository.findByBusinessNameIgnoreCase(references.getBusinessName());

        if (sameName.isPresent())
            throw new BadRequestExceptions("Ja existe um contato de referência com o nome informado");

        References data = findById(id);
        BeanUtils.copyProperties(references, data, "id");
        return repository.save(data);
    }

    public References changeStatus(Long id) {
        References data = findById(id);
        data.setStatus(!data.getStatus());
        return repository.save(data);
    }
}
