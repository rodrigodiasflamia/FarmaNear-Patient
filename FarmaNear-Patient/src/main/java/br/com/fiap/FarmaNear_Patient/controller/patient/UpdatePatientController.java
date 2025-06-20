package br.com.fiap.FarmaNear_Patient.controller.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.usecases.patient.UpdatePatientUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdatePatientController {

    private final UpdatePatientUseCase updatePatientUseCase;

    public UpdatePatientController(UpdatePatientUseCase updatePatientUseCase) {
        this.updatePatientUseCase = updatePatientUseCase;
    }

    public PatientDto updatePatient(PatientDto patientDto) {
        return updatePatientUseCase.updatePatient(patientDto);
    }
}