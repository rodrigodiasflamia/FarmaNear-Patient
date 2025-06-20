package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicationUseCase {

    private final IMedicationJpaGateway medicationJpaGateway;

    public CreateMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        this.medicationJpaGateway = medicationJpaGateway;
    }

    public MedicationDto createMedication(MedicationDto medicationDto) {
        return medicationJpaGateway.createMedication(medicationDto);
    }
}