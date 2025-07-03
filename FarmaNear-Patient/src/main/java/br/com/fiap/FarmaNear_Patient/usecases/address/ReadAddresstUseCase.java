package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;

    public ReadAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        this.addressJpaGateway = addressJpaGateway;
    }

    public AddressDto readAddress(Long addressId) {
        return addressJpaGateway.readAddress(addressId);
    }

    public AddressDto readAddressPatient(Long patientId) {
        return addressJpaGateway.readAddressPatient(patientId);
    }
}