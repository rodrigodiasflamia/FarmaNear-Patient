package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;

    public CreateAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        this.addressJpaGateway = addressJpaGateway;
    }

    public AddressDto createAddress(AddressDto addressDto) {
        return addressJpaGateway.createAddress(addressDto);
    }
}