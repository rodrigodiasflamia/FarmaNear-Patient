package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;

public interface IAddressJpaGateway {

    AddressDto createAddress(AddressDto addressDto);

    AddressDto readAddress(Long addressId);

    AddressDto readAddressPatient(Long patientId);

    AddressDto updateAddress(AddressDto addressDto);

    void deleteAddress(Long addressId);
}