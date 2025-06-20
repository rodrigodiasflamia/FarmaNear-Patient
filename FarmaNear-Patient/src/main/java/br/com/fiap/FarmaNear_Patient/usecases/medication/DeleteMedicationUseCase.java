package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class DeleteMedicationUseCase {

    private final IMedicationJpaGateway medicationJpaGateway;

    public DeleteMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        this.medicationJpaGateway = medicationJpaGateway;
    }

    public void deleteMedication(Long medicationId){
        medicationJpaGateway.deleteMedication(medicationId);
    }
}