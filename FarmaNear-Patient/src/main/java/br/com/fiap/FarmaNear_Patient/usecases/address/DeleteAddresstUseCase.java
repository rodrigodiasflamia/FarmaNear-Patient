package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class DeleteAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;

    public DeleteAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        this.addressJpaGateway = addressJpaGateway;
    }

    public void deleteAddress(Long addressId){
        addressJpaGateway.deleteAddress(addressId);
    }
}