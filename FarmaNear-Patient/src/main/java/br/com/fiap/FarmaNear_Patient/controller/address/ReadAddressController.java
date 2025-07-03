package br.com.fiap.FarmaNear_Patient.controller.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.usecases.address.ReadAddresstUseCase;
import org.springframework.stereotype.Service;

@Service
public class ReadAddressController {

    private final ReadAddresstUseCase readAddresstUseCase;

    public ReadAddressController(ReadAddresstUseCase readAddresstUseCase) {
        this.readAddresstUseCase = readAddresstUseCase;
    }

    public AddressDto readAddress(Long addressId) {
        return readAddresstUseCase.readAddress(addressId);
    }

    public AddressDto readAddressPatient(Long patientId) {
        return readAddresstUseCase.readAddressPatient(patientId);
    }
}