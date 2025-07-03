package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;

import java.util.List;

public interface IMedicationJpaGateway {

    MedicationDto createMedication(MedicationDto medicationDto);

    MedicationDto readMedication(Long medicationId);

    List<MedicationDto> readMedicationPatient(Long patientId);

    MedicationDto updateMedication(MedicationDto medicationDto);

    void deleteMedication(Long medicationId);
}