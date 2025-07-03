package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.entities.address.Address;
import br.com.fiap.FarmaNear_Patient.entities.patient.Patient;
import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressRepository;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddressJpaRepository implements IAddressJpaGateway {

    private final AddressRepository addressRepository;
    private final PatientRepository patientRepository;

    public AddressJpaRepository(AddressRepository addressRepository,
                                PatientRepository patientRepository) {
        this.addressRepository = addressRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public AddressDto createAddress(AddressDto addressDto) {
        PatientEntity patientEntity = patientRepository.findById(addressDto.idPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Patient patient = new Patient(patientEntity.getId(), patientEntity.getName(), patientEntity.getCpf());

        Address address = new Address(addressDto.street(), addressDto.number(), addressDto.neighborhood(), addressDto.complement(), addressDto.city(), addressDto.state(),
                addressDto.zipCode(), addressDto.mobilePhone(), addressDto.email(), patient);
        AddressEntity saved = addressRepository.save(address.createAddressEntity());
        return new AddressDto(saved.getId(), saved.getStreet(), saved.getNumber(), saved.getNeighborhood(), saved.getComplement(), saved.getCity(), saved.getState(),
                saved.getZipCode(), saved.getMobilePhone(), saved.getEmail(), saved.getPatient().getId());
    }

    @Transactional
    public AddressDto readAddress(Long addressId) {
        AddressEntity addressEntity = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        return new AddressDto(addressEntity.getId(), addressEntity.getStreet(), addressEntity.getNumber(), addressEntity.getNeighborhood(), addressEntity.getComplement(),
                addressEntity.getCity(), addressEntity.getState(), addressEntity.getZipCode(), addressEntity.getMobilePhone(), addressEntity.getEmail(), addressEntity.getPatient().getId());
    }

    @Transactional
    public AddressDto updateAddress(AddressDto addressDto) {
        PatientEntity patientEntity = patientRepository.findById(addressDto.idPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        AddressEntity addressEntity = addressRepository.findById(addressDto.id())
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressEntity.setStreet(addressDto.street());
        addressEntity.setNumber(addressDto.number());
        addressEntity.setNeighborhood(addressDto.neighborhood());
        addressEntity.setComplement(addressDto.complement());
        addressEntity.setCity(addressDto.city());
        addressEntity.setState(addressDto.state());
        addressEntity.setZipCode(addressDto.zipCode());
        addressEntity.setMobilePhone(addressDto.mobilePhone());
        addressEntity.setEmail(addressDto.email());
        addressEntity.setPatient(patientEntity);

        AddressEntity saved = addressRepository.save(addressEntity);

        return new AddressDto(saved.getId(), saved.getStreet(), saved.getNumber(), saved.getNeighborhood(), saved.getComplement(), saved.getCity(), saved.getState(),
                saved.getZipCode(), saved.getMobilePhone(), saved.getEmail(), saved.getPatient().getId());
    }

    @Transactional
    public void deleteAddress(Long addressId) {
        AddressEntity addressEntity = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(addressEntity);
    }
}