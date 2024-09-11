package com.project_bootcamp_deal_dio.health_status.person.patient;

import com.project_bootcamp_deal_dio.health_status.person.patient.dto.PatientDTO;
import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import com.project_bootcamp_deal_dio.health_status.utils.models.PaginatedData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {

    private final PatientMapper mapper;
    private final PatientService service;
    private final PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<Patient>> create(@RequestBody PatientDTO patientDTO){
        ApiResponse<Patient> response = new ApiResponse<>();
        Patient patient = mapper.transformDTOToEntity(patientDTO);
        Patient dataSave = service.create(patient);
        response.of(
                HttpStatus.OK,
                "Paciente salvo com sucesso. " + dataSave.getName().toUpperCase(),
                dataSave);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Patient>>> findAllPatient(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC)Pageable pageable,
            PatientCriteria criteria){
        ApiResponse<PaginatedData<Patient>> response = new ApiResponse<>();
        PaginatedData<Patient> data = service.findAll(pageable, criteria);
        response.of(
                HttpStatus.OK,
                "Lista de pacientes.",
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EntityModel<Patient>>> findById(@PathVariable Long id){
        ApiResponse<EntityModel<Patient>> response = new ApiResponse<>();
        Patient data = service.findById(id);
        EntityModel<Patient> resources = EntityModel.of(data);
        resources.add(linkTo(methodOn(PatientController.class).findById(id)).withSelfRel());
        response.of(
                HttpStatus.OK,
                "Paciente encontrado com sucesso.",
                resources);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Patient>> update(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        ApiResponse<Patient> response = new ApiResponse<>();
        Patient patient = mapper.transformDTOToEntity(patientDTO);
        Patient data = service.update(id, patient);
        response.of(
                HttpStatus.OK,
                "Paciente atualizado com sucesso. " + data.getName().toUpperCase(),
                data);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Patient>> delete(@PathVariable Long id){
        ApiResponse<Patient> response = new ApiResponse<>();
        service.delete(id);
        Patient data = service.findById(id);
        if (data.getIsActive() == Boolean.FALSE){
            response.of(
                    HttpStatus.OK,
                    "Paciente deletado com sucesso. " + data.getName().toUpperCase(),
                    data);
        } else {
            response.of(
                    HttpStatus.OK,
                    "Paciente ativado com sucesso. " + data.getName().toUpperCase(),
                    data);
        }
        return ResponseEntity.status(response.getStatus()).body(response);
    }




}