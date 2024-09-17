package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import com.project_bootcamp_deal_dio.health_status.prontuary.responsible.dto.ResponsibleDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsibleMapper {

    private final ModelMapper modelMapper;

    public ResponsibleDTO entityToDto(Responsible responsible) {
        return modelMapper.map(responsible, ResponsibleDTO.class);
    }

    public Responsible dtoToEntity(ResponsibleDTO responsibleDTO) {
        return modelMapper.map(responsibleDTO, Responsible.class);
    }
}
