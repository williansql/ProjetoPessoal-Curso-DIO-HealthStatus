package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import com.project_bootcamp_deal_dio.health_status.prontuary.family_group.dto.FamilyGroupDTO;
import org.hibernate.envers.Audited;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyGroupMapper {

     private ModelMapper modelMapper;

     @Autowired
     public FamilyGroupMapper(ModelMapper modelMapper) {
         this.modelMapper = modelMapper;
     }

     public FamilyGroupDTO entityToDTO(FamilyGroup familyGroup){
         return modelMapper.map(familyGroup, FamilyGroupDTO.class);
     }

     public FamilyGroup dtoToEntity(FamilyGroupDTO familyGroupDTO){
         return modelMapper.map(familyGroupDTO, FamilyGroup.class);
     }


}
