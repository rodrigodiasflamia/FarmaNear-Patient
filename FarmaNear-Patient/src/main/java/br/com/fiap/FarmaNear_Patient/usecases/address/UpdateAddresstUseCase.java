package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;

    public UpdateAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        this.addressJpaGateway = addressJpaGateway;
    }

    public AddressDto updateAddress(AddressDto addressDto) {
        return addressJpaGateway.updateAddress(addressDto);
    }
}