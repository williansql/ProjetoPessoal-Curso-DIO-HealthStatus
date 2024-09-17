package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import com.project_bootcamp_deal_dio.health_status.person.patient.Patient;
import com.project_bootcamp_deal_dio.health_status.person.patient.PatientCriteria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ProntuaryCriteria {

    private Patient patient_name;

    public Specification<Prontuary> createSpecification(ProntuaryCriteria criteria){
        Specification<Prontuary> specs = Specification.where(null);
        if(criteria.getPatient_name() != null){
            specs = specs.or(ProntuaryCriteria
                    .searchByPatientName(criteria.getPatient_name().getId()));
        }
        return specs;
    }

    private static Specification<Prontuary> searchByPatientName(Long patient_name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("patient_name"), patient_name);
    }
}
