package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.dto.ProntuaryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuaryMapper {

    ModelMapper modelMapper;

    @Autowired
    public ProntuaryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProntuaryDTO toDTO(Prontuary prontuary) {
        return modelMapper.map(prontuary, ProntuaryDTO.class);
    }

    public Prontuary toEntity(ProntuaryDTO prontuaryDTO) {
        return modelMapper.map(prontuaryDTO, Prontuary.class);
    }
}
