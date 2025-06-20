package br.com.fiap.FarmaNear_Patient.controller.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.usecases.medication.UpdateMedicationUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateMedicationController {

    private final UpdateMedicationUseCase updateMedicationUseCase;

    public UpdateMedicationController(UpdateMedicationUseCase updateMedicationUseCase) {
        this.updateMedicationUseCase = updateMedicationUseCase;
    }

    public MedicationDto updateMedication(MedicationDto medicationDto){
        return updateMedicationUseCase.updateMedication(medicationDto);
    }
}