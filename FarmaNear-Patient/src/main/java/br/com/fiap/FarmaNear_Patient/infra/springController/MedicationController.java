package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.medication.CreateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.DeleteMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.ReadMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.UpdateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
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

    @PostMapping(value="/create")
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto) {
        MedicationDto medicationSaved = createMedicationController.createMedication(medicationDto);
        return ResponseEntity.ok().body(medicationSaved);
    }

    @GetMapping(value = "/read/{medicationId}")
    public ResponseEntity<MedicationDto> readMedication(@PathVariable Long medicationId) {
        MedicationDto medication = readMedicationController.readMedication(medicationId);
        return ResponseEntity.ok().body(medication);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto medicationUpdated = updateMedicationController.updateMedication(medicationDto);
        return ResponseEntity.ok().body(medicationUpdated);
    }

    @DeleteMapping(value = "/delete/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long medicationId){
        deleteMedicationController.deleteMedication(medicationId);
        return ResponseEntity.ok("Medication successfully deleted!");
    }
}