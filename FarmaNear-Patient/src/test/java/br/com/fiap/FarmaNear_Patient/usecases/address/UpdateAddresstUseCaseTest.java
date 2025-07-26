package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateAddresstUseCaseTest {

    @Mock
    private IAddressJpaGateway addressJpaGateway;

    @Mock
    private IPatientJpaGateway patientJpaGateway;

    @InjectMocks
    private UpdateAddresstUseCase updateAddresstUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdateAddressSuccessfully() {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa",
                "Catanduvas", "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 10L);
        PatientDto patientDto = new PatientDto(10L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(addressJpaGateway.updateAddress(addressDto)).thenReturn(addressDto);
        when(patientJpaGateway.readPatientById(addressDto.idPatient())).thenReturn(patientDto);

        AddressDto addressUpdated = updateAddresstUseCase.updateAddress(addressDto);

        verify(addressJpaGateway, times(1)).updateAddress(addressDto);
        verify(patientJpaGateway, times(1)).readPatientById(addressDto.idPatient());
        assertNotNull(addressUpdated);
        assertEquals(addressDto.id(), addressUpdated.id());
        assertEquals(addressDto.street(), addressUpdated.street());
        assertEquals(addressDto.city(), addressUpdated.city());
    }
}