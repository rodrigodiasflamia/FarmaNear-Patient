package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.medication.CreateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.DeleteMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.ReadMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.UpdateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    private final CreateMedicationController createMedicationController;
    private final ReadMedicationController readMedicationController;
    private final UpdateMedicationController updateMedicationController;
    private final DeleteMedicationController deleteMedicationController;

    public MedicationController(CreateMedicationController createMedicationController,
                                ReadMedicationController readMedicationController,
                                UpdateMedicationController updateMedicationController,
                                DeleteMedicationController deleteMedicationController) {
        this.createMedicationController = createMedicationController;
        this.readMedicationController = readMedicationController;
        this.updateMedicationController = updateMedicationController;
        this.deleteMedicationController = deleteMedicationController;
    }

    @Operation(summary = "Cria o cadastro do medicamento",
               description = "Cria o cadastro do medicamento com name, dosage, administrationRoute, frequency, startDate, endDate e notes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento cadastrado com sucesso!")
    })
    @PostMapping(value="/create")
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto) {
        MedicationDto medicationSaved = createMedicationController.createMedication(medicationDto);
        return ResponseEntity.ok().body(medicationSaved);
    }

    @Operation(summary = "Busca o cadastro do medicamento",
               description = "Retorna o cadastro do medicamento com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do medicamento encontrado com sucesso!")
    })
    @GetMapping(value = "/read/{medicationId}")
    public ResponseEntity<MedicationDto> readMedication(@PathVariable Long medicationId) {
        MedicationDto medication = readMedicationController.readMedication(medicationId);
        return ResponseEntity.ok().body(medication);
    }

    @Operation(summary = "Atualiza o cadastro do medicamento",
            description = "Retorna o cadastro do medicamento atualizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do medicamento atualizado com sucesso!")
    })
    @PutMapping(value = "/update")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto medicationUpdated = updateMedicationController.updateMedication(medicationDto);
        return ResponseEntity.ok().body(medicationUpdated);
    }

    @Operation(summary = "Remove o cadastro do medicamento",
            description = "Remove o cadastro do medicamento com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do medicamento removido com sucesso!")
    })
    @DeleteMapping(value = "/delete/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long medicationId){
        deleteMedicationController.deleteMedication(medicationId);
        return ResponseEntity.ok("Medication successfully deleted!");
    }
}