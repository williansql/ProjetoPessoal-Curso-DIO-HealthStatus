package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle;

import com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle.dto.LifestyleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
public class LifestyleMapper {

    ModelMapper mapper;

    @Autowired
    public LifestyleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public LifestyleDTO entityToDTO(Lifestyle lifestyle) {
        return mapper.map(lifestyle, LifestyleDTO.class);
    }

    public Lifestyle DTOToEntity(LifestyleDTO lifestyleDTO) {
        return mapper.map(lifestyleDTO, Lifestyle.class);
    }

}
