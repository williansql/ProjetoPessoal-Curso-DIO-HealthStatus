package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary;

import com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.dto.ProntuaryDTO;
import com.project_bootcamp_deal_dio.health_status.utils.exception_runtime.BadRequestExceptions;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prontuary")
public class ProntuaryController {

    ProntuaryService prontuaryService;
    ProntuaryMapper prontuaryMapper;

    @Autowired
    public ProntuaryController(
            ProntuaryService prontuaryService,
            ProntuaryMapper prontuaryMapper) {
        this.prontuaryService = prontuaryService;
        this.prontuaryMapper = prontuaryMapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Prontuary>> create (@RequestBody @Valid ProntuaryDTO prontuaryDTO){
        ApiResponse<Prontuary> response = new ApiResponse<>();
        Prontuary prontuary = prontuaryMapper.toEntity(prontuaryDTO);
        Prontuary data = prontuaryService.create(prontuary);
        response.of(
                HttpStatus.OK,
                "Prontuario criado com sucesso: " + data.getCode(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Prontuary>>> findAll(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable,
            ProntuaryCriteria criteria){

        ApiResponse<PaginatedData<Prontuary>> response = new ApiResponse<>();
        PaginatedData<Prontuary> data = prontuaryService.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de prontuarios retornada com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Prontuary>> findById(@PathVariable Long id){
        ApiResponse<Prontuary> response = new ApiResponse<>();
        Prontuary data = prontuaryService.findById(id);
        response.of(
                HttpStatus.OK,
                "Prontuario encontrado com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Prontuary>> update(@PathVariable Long id, @RequestBody @Valid ProntuaryDTO prontuaryDTO){
        ApiResponse<Prontuary> response = new ApiResponse<>();
        Prontuary prontuary = prontuaryMapper.toEntity(prontuaryDTO);
        Prontuary data = prontuaryService.update(id, prontuary);
        response.of(
                HttpStatus.OK,
                "Prontuario atualizado com sucesso: " + data.getCode(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Prontuary>> changeStatus(@PathVariable Long id){
        ApiResponse<Prontuary> response = new ApiResponse<>();
        Prontuary data = prontuaryService.changeStatus(id);
        if (data.getStatus().equals(true))
            response.of(
                    HttpStatus.OK,
                    "Prontuario aberto com sucesso: " + data.getCode(),
                    data);
        else if (data.getStatus().equals(false))
            response.of(
                    HttpStatus.OK,
                    "Prontuario finalizado com sucesso: " + data.getCode(),
                    data);
        else
            throw new BadRequestExceptions("Por favor, informe o status do prontuario");
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
