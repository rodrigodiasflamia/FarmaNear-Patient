package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class ReadPatientUseCase {

    private final IPatientJpaGateway patientJpaGateway;

    public ReadPatientUseCase(IPatientJpaGateway patientJpaGateway) {
        this.patientJpaGateway = patientJpaGateway;
    }

    public PatientDto readPatientById(Long patientId) {
        return patientJpaGateway.readPatientById(patientId);
    }

    public PatientDto readPatientByCpf(String patientCpf) {
        return patientJpaGateway.readPatientByCpf(patientCpf);
    }
}