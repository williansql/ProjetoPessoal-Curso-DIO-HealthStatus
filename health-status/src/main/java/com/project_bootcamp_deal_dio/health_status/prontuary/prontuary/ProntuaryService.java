package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.utils.GenerateProntuaryCode;
import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import com.project_bootcamp_deal_dio.health_status.utils.models.Pagination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProntuaryService {

    GenerateProntuaryCode generateProntuaryCode;
    ProntuaryRepository prontuaryRepository;
    ProntuaryCriteria prontuaryCriteria;

    @Autowired
    public ProntuaryService(
            GenerateProntuaryCode generateProntuaryCode,
            ProntuaryRepository prontuaryRepository,
            ProntuaryCriteria prontuaryCriteria) {
        this.prontuaryRepository = prontuaryRepository;
        this.prontuaryCriteria = prontuaryCriteria;
        this.generateProntuaryCode = generateProntuaryCode;
    }

    public Prontuary create(Prontuary prontuary) {
        prontuary.setCode(generateProntuaryCode.generateCode());
        prontuary.setPatient(prontuary.getPatient());
        return prontuaryRepository.save(prontuary);
    }

    public PaginatedData<Prontuary> findAll(Pageable pageable, ProntuaryCriteria criteria) {
        Specification<Prontuary> specification = prontuaryCriteria.createSpecification(criteria);
        Page<Prontuary> data = prontuaryRepository.findAll(specification, pageable);
        return new PaginatedData<>(data.getContent(), Pagination.from(data, pageable));
    }

    public Prontuary findById(Long id) {
        return prontuaryRepository.findById(id).orElseThrow(
                () -> new BadRequestExceptions("Prontuario não encontrado"));
    }

    public Prontuary update(Long id, Prontuary prontuary) {
        Prontuary data = findById(id);
        BeanUtils.copyProperties(prontuary, data, "id");
        return prontuaryRepository.save(data);
    }

    public Prontuary changeStatus(Long id) {
        Prontuary data = findById(id);
        data.setStatus(!data.getStatus());
        return prontuaryRepository.save(data);
    }
}
