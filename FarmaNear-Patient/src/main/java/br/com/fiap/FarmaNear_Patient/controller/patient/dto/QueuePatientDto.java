package br.com.fiap.FarmaNear_Patient.controller.patient.dto;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;

public record QueuePatientDto(String cpf, AddressDto address) {}