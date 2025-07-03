package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadMedicationUseCase {

    private final IMedicationJpaGateway medicationJpaGateway;

    public ReadMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        this.medicationJpaGateway = medicationJpaGateway;
    }

    public MedicationDto readMedication(Long medicationId) {
        return medicationJpaGateway.readMedication(medicationId);
    }

    public List<MedicationDto> readMedicationPatient(Long patientId) {
        return medicationJpaGateway.readMedicationPatient(patientId);
    }
}