package br.com.fiap.FarmaNear_Patient.controller.medication;

import br.com.fiap.FarmaNear_Patient.usecases.medication.DeleteMedicationUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteMedicationController {

    private final DeleteMedicationUseCase deleteMedicationUseCase;

    public DeleteMedicationController(DeleteMedicationUseCase deleteMedicationUseCase) {
        this.deleteMedicationUseCase = deleteMedicationUseCase;
    }

    public void deleteMedication(Long medicationId){
        deleteMedicationUseCase.deleteMedication(medicationId);
    }
}