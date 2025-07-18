package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.QueuePatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IQueueGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateAddresstUseCase {

    private final IAddressJpaGateway addressJpaGateway;
    private final IPatientJpaGateway patientJpaGateway;
    private final IQueueGateway queueGateway;

    public CreateAddresstUseCase(IAddressJpaGateway addressJpaGateway,
                                 IPatientJpaGateway patientJpaGateway,
                                 IQueueGateway queueGateway) {
        this.addressJpaGateway = addressJpaGateway;
        this.patientJpaGateway = patientJpaGateway;
        this.queueGateway = queueGateway;
    }

    public AddressDto createAddress(AddressDto addressDto) {
        AddressDto dto = addressJpaGateway.createAddress(addressDto);
        PatientDto patientDto = patientJpaGateway.readPatientById(dto.idPatient());

        queueGateway.sendPatientToQueue(new QueuePatientDto(patientDto.cpf(), dto));
        return dto;
    }
}