package br.com.fiap.FarmaNear_Patient.controller.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.usecases.address.CreateAddresstUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressController {

    private final CreateAddresstUseCase createAddresstUseCase;

    public CreateAddressController(CreateAddresstUseCase createAddresstUseCase) {
        this.createAddresstUseCase = createAddresstUseCase;
    }

    public AddressDto createAddress(AddressDto addressDto) {
        return createAddresstUseCase.createAddress(addressDto);
    }
}