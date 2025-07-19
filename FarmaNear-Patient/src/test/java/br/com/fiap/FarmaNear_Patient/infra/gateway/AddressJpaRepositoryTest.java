package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressRepository;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressJpaRepositoryTest {

    @InjectMocks
    private AddressJpaRepository addressJpaRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private PatientRepository patientRepository;

    private PatientEntity patientEntity;

    private AddressEntity addressEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patientEntity = new PatientEntity("Rodrigo Dias Flamia", "974.501.760-41");
        addressEntity = new AddressEntity("Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", patientEntity);
    }

    @Test
    void shouldCreateAddress() {
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));
        Mockito.when(addressRepository.save(Mockito.any(AddressEntity.class))).thenReturn(addressEntity);
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);

        AddressDto addressSaved = addressJpaRepository.createAddress(addressDto);

        assertEquals(addressDto.street(), addressSaved.street());
        assertEquals(addressDto.number(), addressSaved.number());
        assertEquals(addressDto.neighborhood(), addressSaved.neighborhood());
        assertEquals(addressDto.complement(), addressSaved.complement());
        assertEquals(addressDto.city(), addressSaved.city());
        assertEquals(addressDto.state(), addressSaved.state());
        assertEquals(addressDto.zipCode(), addressSaved.zipCode());
        assertEquals(addressDto.mobilePhone(), addressSaved.mobilePhone());
        assertEquals(addressDto.email(), addressSaved.email());
    }

    @Test
    void shouldReadAddress() {
        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(addressEntity));

        AddressDto address = addressJpaRepository.readAddress(1L);

        assertEquals(addressEntity.getStreet(), address.street());
        assertEquals(addressEntity.getNumber(), address.number());
        assertEquals(addressEntity.getNeighborhood(), address.neighborhood());
        assertEquals(addressEntity.getComplement(), address.complement());
        assertEquals(addressEntity.getCity(), address.city());
        assertEquals(addressEntity.getState(), address.state());
        assertEquals(addressEntity.getZipCode(), address.zipCode());
        assertEquals(addressEntity.getMobilePhone(), address.mobilePhone());
        assertEquals(addressEntity.getEmail(), address.email());
    }

    @Test
    void shouldNotReadAddress() {
        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
           addressJpaRepository.readAddress(99L);
        });

        assertEquals("Address not found", thrown.getMessage());
    }

    @Test
    void shouldReadAddressPatient() {
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));
        Mockito.when(addressRepository.readAddressPatient(Mockito.anyLong())).thenReturn(Optional.of(addressEntity));

        AddressDto address = addressJpaRepository.readAddressPatient(1L);

        assertEquals(addressEntity.getStreet(), address.street());
        assertEquals(addressEntity.getNumber(), address.number());
        assertEquals(addressEntity.getNeighborhood(), address.neighborhood());
        assertEquals(addressEntity.getComplement(), address.complement());
        assertEquals(addressEntity.getCity(), address.city());
        assertEquals(addressEntity.getState(), address.state());
        assertEquals(addressEntity.getZipCode(), address.zipCode());
        assertEquals(addressEntity.getMobilePhone(), address.mobilePhone());
        assertEquals(addressEntity.getEmail(), address.email());
    }

    @Test
    void shouldNotReadAddressPatient() {
        Mockito.when(addressRepository.readAddressPatient(Mockito.anyLong())).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            addressJpaRepository.readAddressPatient(99L);
        });

        assertEquals("Address not found", thrown.getMessage());
    }

    @Test
    void shouldUpdateAddress(){
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(addressEntity));
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));
        Mockito.when(addressRepository.save(Mockito.any(AddressEntity.class))).thenReturn(addressEntity);
        AddressDto addressDto = new AddressDto(1L, "Rua Almirante Barroso", "2189", "Bairro Centro Oeste", "Apartamento", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);

        AddressDto addressSaved = addressJpaRepository.updateAddress(addressDto);

        Mockito.verify(addressRepository, Mockito.times(1)).save(Mockito.any(AddressEntity.class));
        assertEquals(addressDto.street(), addressSaved.street());
        assertEquals(addressDto.number(), addressSaved.number());
        assertEquals(addressDto.neighborhood(), addressSaved.neighborhood());
        assertEquals(addressDto.complement(), addressSaved.complement());
        assertEquals(addressDto.city(), addressSaved.city());
        assertEquals(addressDto.state(), addressSaved.state());
        assertEquals(addressDto.zipCode(), addressSaved.zipCode());
        assertEquals(addressDto.mobilePhone(), addressSaved.mobilePhone());
        assertEquals(addressDto.email(), addressSaved.email());
    }

    @Test
    void shouldDeleteAddress() {
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(addressEntity));

        addressJpaRepository.deleteAddress(1L);

        Mockito.verify(addressRepository, Mockito.times(1)).delete(addressEntity);
    }

    @Test
    void shouldNotDeleteAddress() {
        Mockito.when(addressRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            addressJpaRepository.deleteAddress(99L);
        });

        assertEquals("Address not found", thrown.getMessage());
    }
}