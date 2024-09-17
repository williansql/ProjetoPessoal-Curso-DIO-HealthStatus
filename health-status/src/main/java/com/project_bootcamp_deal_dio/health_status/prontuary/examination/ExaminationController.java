package com.project_bootcamp_deal_dio.health_status.prontuary.examination;

import com.project_bootcamp_deal_dio.health_status.prontuary.examination.dto.ExaminationDTO;
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
@RequestMapping("examination")
public class ExaminationController {

    ExaminationService service;
    ExaminationMapper mapper;

    public ExaminationController(
            ExaminationService service,
            ExaminationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Examination>> create(@RequestBody @Valid ExaminationDTO dto){
        ApiResponse<Examination> response = new ApiResponse<>();
        Examination examination = mapper.toEntity(dto);
        Examination data = service.create(examination);
        response.of(
                HttpStatus.OK,
                "Exame criado com sucesso: " + data.getTypeExamination().toLowerCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Examination>>> findAll(
            @PageableDefault(size = 10, sort = "TtypeExamination", direction = Sort.Direction.ASC) Pageable pageable,
            ExaminationCriteria criteria){
        ApiResponse<PaginatedData<Examination>> response = new ApiResponse<>();
        PaginatedData<Examination> data = service.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de exames retornada com sucesso",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Examination>> findById(@PathVariable Long id){
        ApiResponse<Examination> response = new ApiResponse<>();
        Examination data = service.findById(id);
        response.of(
                HttpStatus.OK,
                "Exame retornado com sucesso: " + data.getTypeExamination().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Examination>> update(@PathVariable Long id, @RequestBody @Valid ExaminationDTO dto){
        ApiResponse<Examination> response = new ApiResponse<>();
        Examination examination = mapper.toEntity(dto);
        Examination data = service.update(id, examination);
        response.of(
                HttpStatus.OK,
                "Exame atualizado com sucesso: " + data.getTypeExamination().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Examination>> changeStatus(@PathVariable Long id){
        ApiResponse<Examination> response = new ApiResponse<>();
        Examination data = service.changeStatus(id);
        response.of(
                HttpStatus.OK,
                "Exame atualizado com sucesso: " + data.getStatus().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
