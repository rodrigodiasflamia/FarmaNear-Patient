package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.QueuePatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IQueueGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;
    private final IPatientJpaGateway patientJpaGateway;
    private final IQueueGateway queueGateway;

    public UpdateAddresstUseCase(IAddressJpaGateway addressJpaGateway,
                                 IPatientJpaGateway patientJpaGateway,
                                 IQueueGateway queueGateway) {
        this.addressJpaGateway = addressJpaGateway;
        this.patientJpaGateway = patientJpaGateway;
        this.queueGateway = queueGateway;
    }

    public AddressDto updateAddress(AddressDto addressDto) {
        AddressDto dto =  addressJpaGateway.updateAddress(addressDto);
        PatientDto patientDto = patientJpaGateway.readPatient(dto.idPatient());

        queueGateway.sendPatientToQueue(new QueuePatientDto(patientDto.cpf(), dto));
        return dto;
    }
}