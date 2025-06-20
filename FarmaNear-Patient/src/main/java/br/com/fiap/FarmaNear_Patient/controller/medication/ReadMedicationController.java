package br.com.fiap.FarmaNear_Patient.controller.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.usecases.medication.ReadMedicationUseCase;
import org.springframework.stereotype.Service;

@Service
public class ReadMedicationController {

    private final ReadMedicationUseCase readMedicationUseCase;

    public ReadMedicationController(ReadMedicationUseCase readMedicationUseCase){
        this.readMedicationUseCase = readMedicationUseCase;
    }

    public MedicationDto readMedication(Long medicationId){
        return readMedicationUseCase.readMedication(medicationId);
    }
}