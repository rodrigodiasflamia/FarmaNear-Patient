package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;

public interface IPatientJpaGateway {

    PatientDto createPatient(PatientDto patientDto);

    PatientDto readPatient(Long patientId);

    PatientDto updatePatient(PatientDto patientDto);

    void deletePatient(Long patientId);
}