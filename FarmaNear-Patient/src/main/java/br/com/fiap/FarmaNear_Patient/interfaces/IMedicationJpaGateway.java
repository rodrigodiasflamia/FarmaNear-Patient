package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;

public interface IMedicationJpaGateway {

    MedicationDto createMedication(MedicationDto medicationDto);

    MedicationDto readMedication(Long medicationId);

    MedicationDto updateMedication(MedicationDto medicationDto);

    void deleteMedication(Long medicationId);
}