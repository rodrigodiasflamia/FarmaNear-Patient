package br.com.fiap.FarmaNear_Patient.controller.address.dto;

public record AddressDto(Long id, String street, String number, String neighborhood, String complement, String city, String state, String zipCode, String mobilePhone, String email, Long idPatient) { }