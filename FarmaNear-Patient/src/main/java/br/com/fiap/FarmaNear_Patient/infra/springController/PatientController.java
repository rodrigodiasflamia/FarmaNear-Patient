package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.patient.CreatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.DeletePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.ReadPatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.UpdatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final CreatePatientController createPatientController;
    private final ReadPatientController readPatientController;
    private final UpdatePatientController updatePatientController;
    private final DeletePatientController deletePatientController;
    
    public PatientController(CreatePatientController createPatientController,
                             ReadPatientController readPatientController,
                             UpdatePatientController updatePatientController,
                             DeletePatientController deletePatientController) {
        this.createPatientController = createPatientController;
        this.readPatientController = readPatientController;
        this.updatePatientController = updatePatientController;
        this.deletePatientController = deletePatientController;
    }

    @Operation(summary = "Cria o cadastro do paciente",
               description = "Cria o cadastro do paciente com name e cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente cadastrado com sucesso!")
    })
    @PostMapping(value="/create")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        PatientDto patientSaved = createPatientController.createPatient(patientDto);
        return ResponseEntity.ok().body(patientSaved);
    }

    @Operation(summary = "Busca o cadastro do paciente",
               description = "Retorna o cadastro do paciente com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do paciente encontrado com sucesso!")
    })
    @GetMapping(value="/read/{patientId}")
    public ResponseEntity<PatientDto> readPatient(@PathVariable Long patientId) {
        PatientDto patient = readPatientController.readPatient(patientId);
        return ResponseEntity.ok().body(patient);
    }

    @Operation(summary = "Atualiza o cadastro do paciente",
            description = "Retorna o cadastro do paciente atualizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do paciente atualizado com sucesso!")
    })
    @PutMapping(value="/update")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
        PatientDto patientUpdated = updatePatientController.updatePatient(patientDto);
        return ResponseEntity.ok().body(patientUpdated);
    }

    @Operation(summary = "Remove o cadastro do paciente",
            description = "Remove o cadastro do paciente com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do paciente removido com sucesso!")
    })
    @DeleteMapping(value="/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        deletePatientController.deletePatient(patientId);
        return ResponseEntity.ok("Patient successfully deleted!");
    }
}