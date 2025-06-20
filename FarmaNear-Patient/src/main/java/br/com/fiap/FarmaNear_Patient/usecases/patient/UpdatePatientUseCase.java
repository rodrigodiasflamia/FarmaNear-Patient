package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdatePatientUseCase {

    private final IPatientJpaGateway patientJpaGateway;

    public UpdatePatientUseCase(IPatientJpaGateway patientJpaGateway) {
        this.patientJpaGateway = patientJpaGateway;
    }

    public PatientDto updatePatient(PatientDto patientDto) {
        return patientJpaGateway.updatePatient(patientDto);
    }
}