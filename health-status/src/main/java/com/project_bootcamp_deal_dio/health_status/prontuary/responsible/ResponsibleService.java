package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.NotFoundException;
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
public class ResponsibleService {

    private final ResponsibleRepository repository;
    private final ResponsibleCriteria responsibleCriteria;

    public Responsible create(Responsible responsible) {

        Optional<Responsible> sameName = repository.findByNameIgnoreCase(responsible.getName());
        Optional<Responsible> sameDocument = repository.findByDocument(responsible.getDocument());
        Optional<Responsible> sameEmail = repository.findByEmail(responsible.getEmail());

        if (sameName.isPresent())
            throw new BadRequestExceptions("Já existe um responsável com esse nome.");
        else if (sameDocument.isPresent())
            throw new BadRequestExceptions("Já existe um responsável com esse documento.");
        else if (sameEmail.isPresent())
            throw new BadRequestExceptions("Já existe um responsável com esse email.");
        else
            return repository.save(responsible);
    }

    public PaginatedData<Responsible> findAll(Pageable pageable, ResponsibleCriteria criteria) {
        Specification<Responsible> specification = responsibleCriteria.createSpecification(criteria);
        Page<Responsible> page = repository.findAll(specification, pageable);
        return new PaginatedData<>(page.getContent(), Pagination.from(page, pageable));
    }

    public Responsible findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Responsável não encontrado."));
    }

    public Responsible update(Responsible responsible) {
        Responsible find = findById(responsible.getId());
        BeanUtils.copyProperties(responsible, find, "id");
        return repository.save(find);
    }

    public Responsible changeStatus(Long id) {
        Responsible responsible = findById(id);
        responsible.setStatus(!responsible.getStatus());
        return repository.save(responsible);
    }
}
