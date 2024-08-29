package com.project_bootcamp_deal_dio.health_status.person.patient;

import com.project_bootcamp_deal_dio.health_status.person.patient.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientMapper {

    private final ModelMapper modelMapper;

    public PatientDTO transformEntityToDTO(Patient patient){
        return modelMapper.map(patient, PatientDTO.class);
    }

    public Patient transformDTOToEntity(PatientDTO patientDTO){
        return modelMapper.map(patientDTO, Patient.class);
    }

}