package br.com.fiap.FarmaNear_Patient.controller.patient;

import br.com.fiap.FarmaNear_Patient.usecases.patient.DeletePatientUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeletePatientController {

    private final DeletePatientUseCase deletePatientUseCase;

    public DeletePatientController(DeletePatientUseCase deletePatientUseCase) {
        this.deletePatientUseCase = deletePatientUseCase;
    }

    public void deletePatient(Long patientId) {
        deletePatientUseCase.deletePatient(patientId);
    }
}
