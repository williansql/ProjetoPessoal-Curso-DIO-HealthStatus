package com.project_bootcamp_deal_dio.health_status.prontuary.responsible;

import com.project_bootcamp_deal_dio.health_status.prontuary.responsible.dto.ResponsibleDTO;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("responsible")
@RequiredArgsConstructor
public class ResponsibleController {

    private final ResponsibleService service;
    private final ResponsibleMapper mapper;

    @PostMapping
    public ResponseEntity<ApiResponse<Responsible>> create(@RequestBody @Valid ResponsibleDTO dto) {
        ApiResponse<Responsible> response = new ApiResponse<>();
        Responsible responsible = mapper.dtoToEntity(dto);
        Responsible data = service.create(responsible);
        response.of(HttpStatus.OK,
                "Responsável criado com sucesso: " + data.getName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Responsible>>> findAll(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
            ResponsibleCriteria criteria) {
        ApiResponse<PaginatedData<Responsible>> response = new ApiResponse<>();
        PaginatedData<Responsible> data = service.findAll(pageable, criteria);
        response.of(HttpStatus.OK, "Lista de responsáveis carregada com sucesso!", data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Responsible>> findById(@PathVariable Long id) {
        ApiResponse<Responsible> response = new ApiResponse<>();
        Responsible data = service.findById(id);
        response.of(HttpStatus.OK, "Responsável carregado com sucesso!", data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Responsible>> update(
            @PathVariable Long id, @RequestBody @Valid ResponsibleDTO dto) {
        ApiResponse<Responsible> response = new ApiResponse<>();
        Responsible responsible = mapper.dtoToEntity(dto);
        responsible.setId(id);
        Responsible data = service.update(responsible);
        response.of(HttpStatus.OK,
                "Responsável atualizado com sucesso: " + data.getName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Responsible>> changeStatus(@PathVariable Long id){
        ApiResponse<Responsible> response = new ApiResponse<>();
        Responsible data = service.changeStatus(id);
        if (data.getStatus().equals(true)){
            response.of(HttpStatus.OK,
                    "Responsável recuperado com sucesso: " + data.getName().toUpperCase(),
                    data);
        } else if (data.getStatus().equals(false)){
            response.of(HttpStatus.OK,
                    "Responsável desativado com sucesso: " + data.getName().toUpperCase(),
                    data);
        }
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
