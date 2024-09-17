package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import com.project_bootcamp_deal_dio.health_status.prontuary.examination.dto.ExaminationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationMapper {

    ModelMapper modelMapper;

    @Autowired
    public ExaminationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ExaminationDTO toDTO(Examination examination) {
        return modelMapper.map(examination, ExaminationDTO.class);
    }

    public Examination toEntity(ExaminationDTO examinationDTO) {
        return modelMapper.map(examinationDTO, Examination.class);
    }
}
