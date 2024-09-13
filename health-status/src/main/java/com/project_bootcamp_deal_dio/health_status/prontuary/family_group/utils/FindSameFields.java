package com.project_bootcamp_deal_dio.health_status.prontuary.family_group.utils;

import com.project_bootcamp_deal_dio.health_status.prontuary.family_group.FamilyGroup;
import com.project_bootcamp_deal_dio.health_status.prontuary.family_group.FamilyGroupRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
public class FindSameFields {

    private FamilyGroupRepository repository;

    @Autowired
    public FindSameFields(
            FamilyGroupRepository repository){
        this.repository = repository;
    }

    public FamilyGroup sameName(String responsibleName){
        Optional<FamilyGroup> same =
                repository.findByResponsibleNameIgnoreCase(responsibleName);
        return same.get();
    }

    public FamilyGroup sameDocument(String responsibleDocument){
        Optional<FamilyGroup> same =
                repository.findByResponsibleDocument(responsibleDocument);
        return same.get();
    }

    public FamilyGroup sameEmail(String responsibleEmail){
        Optional<FamilyGroup> same =
                repository.findByResponsibleEmailIgnoreCase(responsibleEmail);
        return same.get();
    }
}
