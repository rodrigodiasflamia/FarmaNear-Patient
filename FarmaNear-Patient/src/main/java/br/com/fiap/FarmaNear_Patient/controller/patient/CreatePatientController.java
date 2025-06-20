package br.com.fiap.FarmaNear_Patient.controller.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.usecases.patient.CreatePatientUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientController {

    private final CreatePatientUseCase createPatientUseCase;

    public CreatePatientController(CreatePatientUseCase createPatientUseCase) {
        this.createPatientUseCase = createPatientUseCase;
    }

    public PatientDto createPatient(PatientDto patientDto) {
        return createPatientUseCase.createPatient(patientDto);
    }
}