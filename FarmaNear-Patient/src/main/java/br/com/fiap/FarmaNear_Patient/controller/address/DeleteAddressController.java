package br.com.fiap.FarmaNear_Patient.controller.address;

import br.com.fiap.FarmaNear_Patient.usecases.address.DeleteAddresstUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteAddressController {

    private final DeleteAddresstUseCase deleteAddresstUseCase;

    public DeleteAddressController(DeleteAddresstUseCase deleteAddresstUseCase) {
        this.deleteAddresstUseCase = deleteAddresstUseCase;
    }

    public void deleteAddress(Long addressId){
        deleteAddresstUseCase.deleteAddress(addressId);
    }
}