package br.com.fiap.FarmaNear_Patient.controller.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.usecases.address.UpdateAddresstUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddressController {

    private final UpdateAddresstUseCase updateAddresstUseCase;

    public UpdateAddressController(UpdateAddresstUseCase updateAddresstUseCase){
        this.updateAddresstUseCase = updateAddresstUseCase;
    }

    public AddressDto updateAddress(AddressDto addressDto){
        return updateAddresstUseCase.updateAddress(addressDto);
    }
}