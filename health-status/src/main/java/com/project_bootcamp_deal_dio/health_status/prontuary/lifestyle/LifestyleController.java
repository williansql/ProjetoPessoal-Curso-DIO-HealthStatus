package com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle;

import com.project_bootcamp_deal_dio.health_status.prontuary.lifestyle.dto.LifestyleDTO;
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
@RequestMapping("lifestyle")
public class LifestyleController {

    LifestyleMapper mapper;
    LifestyleService service;

    public LifestyleController(
            LifestyleMapper mapper,
            LifestyleService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Lifestyle>> create(@RequestBody @Valid LifestyleDTO dto){
        ApiResponse<Lifestyle> response = new ApiResponse<>();
        Lifestyle lifestyle = mapper.DTOToEntity(dto);
        Lifestyle data = service.create(lifestyle);
        response.of(
                HttpStatus.OK,
                "Contato de alimentação criado com sucesso: "
                        + data.getEatingHabits().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Lifestyle>>> findAll(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
            LifestyleCriteria criteria){
        ApiResponse<PaginatedData<Lifestyle>> response = new ApiResponse<>();
        PaginatedData<Lifestyle> data = service.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de Estilo de vida retornada com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse<Lifestyle>> findById(@PathVariable Long id){
        ApiResponse<Lifestyle> response = new ApiResponse<>();
        Lifestyle data = service.findById(id);
        response.of(
                HttpStatus.OK,
                "Contato de alimentação encontrado com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/id")
    public ResponseEntity<ApiResponse<Lifestyle>> update(@PathVariable Long id, @RequestBody @Valid LifestyleDTO dto){
        ApiResponse<Lifestyle> response = new ApiResponse<>();
        Lifestyle lifestyle = mapper.DTOToEntity(dto);
        Lifestyle data = service.update(id, lifestyle);
        response.of(
                HttpStatus.OK,
                "Contato de alimentação atualizado com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/id")
    public ResponseEntity<ApiResponse<Lifestyle>> changeStatus(@PathVariable Long id){
        ApiResponse<Lifestyle> response = new ApiResponse<>();
        Lifestyle data = service.changeStatus(id);
        if (data.getStatus().equals(true))
            response.of(
                    HttpStatus.OK,
                    "Contato de alimentação recuperado com sucesso",
                    data);
        else
            response.of(
                    HttpStatus.OK,
                    "Contato de alimentação desativado com sucesso",
                    data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
