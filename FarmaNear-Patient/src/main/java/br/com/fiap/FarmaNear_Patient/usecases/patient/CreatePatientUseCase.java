package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientUseCase {

    private final IPatientJpaGateway patientJpaGateway;

    public CreatePatientUseCase(IPatientJpaGateway patientJpaGateway) {
        this.patientJpaGateway = patientJpaGateway;
    }

    public PatientDto createPatient(PatientDto patientDto) {
        return patientJpaGateway.createPatient(patientDto);
    }
}