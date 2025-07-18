package br.com.fiap.FarmaNear_Patient.controller.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.usecases.patient.ReadPatientUseCase;
import org.springframework.stereotype.Service;

@Service
public class ReadPatientController {

    private final ReadPatientUseCase readPatientUseCase;

    public ReadPatientController(ReadPatientUseCase readPatientUseCase) {
        this.readPatientUseCase = readPatientUseCase;
    }

    public PatientDto readPatientById(Long patientId) {
        return readPatientUseCase.readPatientById(patientId);
    }

    public PatientDto readPatientByCpf(String patientCpf) {
        return readPatientUseCase.readPatientByCpf(patientCpf);
    }
}