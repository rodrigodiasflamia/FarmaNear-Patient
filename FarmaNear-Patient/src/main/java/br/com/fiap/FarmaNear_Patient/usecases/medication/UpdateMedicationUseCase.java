package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdateMedicationUseCase {

    private final IMedicationJpaGateway medicationJpaGateway;

    public UpdateMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        this.medicationJpaGateway = medicationJpaGateway;
    }

    public MedicationDto updateMedication(MedicationDto medicationDto) {
        return medicationJpaGateway.updateMedication(medicationDto);
    }
}