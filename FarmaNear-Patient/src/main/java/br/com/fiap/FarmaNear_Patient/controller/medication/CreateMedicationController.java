package br.com.fiap.FarmaNear_Patient.controller.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.usecases.medication.CreateMedicationUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicationController {

    private final CreateMedicationUseCase createMedicationUseCase;

    public CreateMedicationController(CreateMedicationUseCase createMedicationUseCase) {
        this.createMedicationUseCase = createMedicationUseCase;
    }

    public MedicationDto createMedication(MedicationDto medicationDto){
        return createMedicationUseCase.createMedication(medicationDto);
    }
}