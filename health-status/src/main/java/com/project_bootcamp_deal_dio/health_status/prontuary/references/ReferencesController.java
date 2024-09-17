package com.project_bootcamp_deal_dio.health_status.prontuary.references;

import com.project_bootcamp_deal_dio.health_status.prontuary.references.dto.ReferencesDTO;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("references")
@RequiredArgsConstructor
public class ReferencesController {

    ReferencesService service;
    private final ReferencesMapper mapper;

    @PostMapping
    public ResponseEntity<ApiResponse<References>> create(@RequestBody @Valid ReferencesDTO dto){
        ApiResponse<References> response = new ApiResponse<>();
        References references = mapper.DTOToEntity(dto);
        References data = service.create(references);
        response.of(
                HttpStatus.OK,
                "Contato de referência criado com sucesso: "
                        + data.getBusinessName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<References>>> findAll(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
            ReferencesCriteria criteria){
        ApiResponse<PaginatedData<References>> response = new ApiResponse<>();
        PaginatedData<References> data = service.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de contatos de referência retornada com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse<References>> findById(@PathVariable Long id){
        ApiResponse<References> response = new ApiResponse<>();
        References data = service.findById(id);
        response.of(
                HttpStatus.OK,
                "Contato de referência encontrado com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/id")
    public ResponseEntity<ApiResponse<References>> update(
            @PathVariable Long id, @RequestBody @Valid ReferencesDTO dto){
        ApiResponse<References> response = new ApiResponse<>();
        References references = mapper.DTOToEntity(dto);
        References data = service.update(id, references);
        response.of(
                HttpStatus.OK,
                "Contato de referência atualizado com sucesso: "
                        + data.getBusinessName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/id")
    public ResponseEntity<ApiResponse<References>> changeStatus(
            @PathVariable Long id){
        ApiResponse<References> response = new ApiResponse<>();
        References data = service.changeStatus(id);
        if (data.getStatus().equals(true))
            response.of(
                    HttpStatus.OK,
                    "Status do contato de referência Reativado com sucesso",
                    data);
        else if (data.getStatus().equals(false))
            response.of(
                    HttpStatus.OK,
                    "Status do contato de referência Desativado com sucesso",
                    data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
