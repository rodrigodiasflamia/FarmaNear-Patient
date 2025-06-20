package br.com.fiap.FarmaNear_Patient.controller.patient.dto;

import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;

import java.util.Set;

public record PatientDto(Long id, String name, String cpf, AddressEntity address, Set<MedicationEntity> medications) { }
