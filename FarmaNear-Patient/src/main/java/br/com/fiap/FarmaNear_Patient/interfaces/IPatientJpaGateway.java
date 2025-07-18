package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;

public interface IPatientJpaGateway {

    PatientDto createPatient(PatientDto patientDto);

    PatientDto readPatientById(Long patientId);

    PatientDto readPatientByCpf(String patientCpf);

    PatientDto updatePatient(PatientDto patientDto);

    void deletePatient(Long patientId);
}