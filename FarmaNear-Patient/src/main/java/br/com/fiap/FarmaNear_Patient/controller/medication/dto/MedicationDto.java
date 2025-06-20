package br.com.fiap.FarmaNear_Patient.controller.medication.dto;

import java.time.LocalDate;

public record MedicationDto(Long id, String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes) { }