package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class DeletePatientUseCase {

    private final IPatientJpaGateway patientJpaGateway;

    public DeletePatientUseCase(IPatientJpaGateway patientJpaGateway) {
        this.patientJpaGateway = patientJpaGateway;
    }

    public void deletePatient(Long patientId) {
        patientJpaGateway.deletePatient(patientId);
    }
}