package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import com.project_bootcamp_deal_dio.health_status.prontuary.family_group.utils.FindSameFields;
import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import com.project_bootcamp_deal_dio.health_status.utils.models.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FamilyGroupService {

    private final FamilyGroupRepository repository;
    private final FindSameFields sameFields;
    private final FamilyGroupCriteria familyGroupCriteria;

    @Autowired
    public FamilyGroupService (
            FamilyGroupRepository repository,
            FindSameFields sameFields,
            FamilyGroupCriteria familyGroupCriteria){
        this.repository = repository;
        this.sameFields = sameFields;
        this.familyGroupCriteria = familyGroupCriteria;
    }


    public FamilyGroup create(FamilyGroup familyGroup) {

        FamilyGroup findName = sameFields.sameName(familyGroup.getResponsibleName());
        FamilyGroup findDocument = sameFields.sameName(familyGroup.getResponsibleDocument());
        FamilyGroup findEmail = sameFields.sameName(familyGroup.getResponsibleEmail());

        if (findName != null)
            throw new BadRequestExceptions("Já existe um responsável com esse nome em nosso banco de dados");
        else if (findDocument != null)
            throw new BadRequestExceptions("Já existe esse documento em nosso banco de dados");
        else if (findEmail != null)
            throw new BadRequestExceptions("Já existe um responsável com esse email em nosso banco de dados");

        return repository.save(familyGroup);
    }

    public PaginatedData<FamilyGroup> findAll(Pageable pageable, FamilyGroupCriteria criteria) {
        Specification<FamilyGroup> specification = familyGroupCriteria.createSpecification(criteria);
        Page<FamilyGroup> page = repository.findAll(pageable, specification);
        return new PaginatedData<>(page.getContent(), Pagination.from(page, pageable));
    }

    public FamilyGroup findById(Long id) {
        FamilyGroup find = repository.findById(id).orElseThrow(
                () -> new BadRequestExceptions("Responsável não encontrado"));
        return find;
    }

    public FamilyGroup update(Long id, FamilyGroup familyGroup) {
        FamilyGroup findName = sameFields.sameName(familyGroup.getResponsibleName());
        FamilyGroup findDocument = sameFields.sameName(familyGroup.getResponsibleDocument());
        FamilyGroup findEmail = sameFields.sameName(familyGroup.getResponsibleEmail());

        if (findName != null)
            throw new BadRequestExceptions("Já existe um responsável com esse nome em nosso banco de dados");
        else if (findDocument != null)
            throw new BadRequestExceptions("Já existe esse documento em nosso banco de dados");
        else if (findEmail != null)
            throw new BadRequestExceptions("Já existe um responsável com esse email em nosso banco de dados");

        FamilyGroup find = findById(id);
        find.setResponsibleName(familyGroupCriteria.getResponsibleName().toLowerCase());
        find.setResponsibleDocument(familyGroup.getResponsibleDocument().toLowerCase());
        find.setResponsiblePhone(familyGroup.getResponsiblePhone());
        find.setResponsibleAddress(familyGroup.getResponsibleAddress().toLowerCase());
        find.setResponsibleEmail(familyGroup.getResponsibleEmail().toLowerCase());
        find.setRelationship(familyGroup.getRelationship().toLowerCase());
        find.setStatus(familyGroup.getStatus());
        return repository.save(find);
    }

    public FamilyGroup changeStatus(Long id) {
        FamilyGroup find = findById(id);
        find.setStatus(!find.getStatus());
        return repository.save(find);
    }
}
