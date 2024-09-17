package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import com.project_bootcamp_deal_dio.health_status.prontuary.references.dto.ReferencesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ReferencesMapper {

    ModelMapper modelMapper;

    @Autowired
    public ReferencesMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ReferencesDTO entityToDTO(References references){
        return modelMapper.map(references, ReferencesDTO.class);
    }

    public References DTOToEntity(ReferencesDTO referencesDTO){
        return modelMapper.map(referencesDTO, References.class);
    }
}
