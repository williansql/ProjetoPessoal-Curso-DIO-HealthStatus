package com.project_bootcamp_deal_dio.health_status.prontuary.family_group;

import com.project_bootcamp_deal_dio.health_status.prontuary.family_group.dto.FamilyGroupDTO;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family_group")
public class FamilyGroupController {

    private FamilyGroupService service;
    private FamilyGroupMapper mapper;

    public FamilyGroupController(
            FamilyGroupService service,
            FamilyGroupMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FamilyGroup>> create(
            @RequestBody @Valid FamilyGroupDTO familyGroupDTO){
        ApiResponse<FamilyGroup> response = new ApiResponse<>();
        FamilyGroup familyGroup = mapper.dtoToEntity(familyGroupDTO);
        FamilyGroup save = service.create(familyGroup);
        response.of(
                HttpStatus.OK,
                "Responsável salvo com sucesso: " + save.getResponsibleName().toUpperCase(),
                save);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<FamilyGroup>>> findAll(
            @PageableDefault(size = 10, sort = "responsibleName", direction = Sort.Direction.ASC)Pageable pageable,
            FamilyGroupCriteria criteria){
        ApiResponse<PaginatedData<FamilyGroup>> response = new ApiResponse<>();
        PaginatedData<FamilyGroup> data = service.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de Responsáveis ",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FamilyGroup>> findById(@PathVariable Long id){
        ApiResponse<FamilyGroup> response = new ApiResponse<>();
        FamilyGroup data = service.findById(id);
        response.of(
                HttpStatus.OK,
                "Responsável encontrado: " + data.getResponsibleName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FamilyGroup>> update(
            @PathVariable Long id, @RequestBody FamilyGroupDTO familyGroupDTO){
        ApiResponse<FamilyGroup> response = new ApiResponse<>();
        FamilyGroup familyGroup = mapper.dtoToEntity(familyGroupDTO);
        FamilyGroup data = service.update(id, familyGroup);
        response.of(
                HttpStatus.OK,
                "Responsável editado com sucesso: " + data.getResponsibleName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<FamilyGroup>> changeStatus(@PathVariable Long id){
        ApiResponse<FamilyGroup> response = new ApiResponse<>();
        FamilyGroup data = service.changeStatus(id);
        if (data.getStatus().equals(true))
            response.of(
                    HttpStatus.OK,
                    "Responsável recuperado com sucesso: "
                            + data.getResponsibleName().toUpperCase(),
                    data);
        response.of(
                HttpStatus.OK,
                "Responsável excluído com sucesso: "
                        + data.getResponsibleName().toUpperCase());
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
