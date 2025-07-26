package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadAddresstUseCaseTest {

    @Mock
    private IAddressJpaGateway addressJpaGateway;

    @InjectMocks
    private ReadAddresstUseCase readAddresstUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReadAddressById() {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa",
                "Catanduvas", "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 10L);
        when(addressJpaGateway.readAddress(1L)).thenReturn(addressDto);

        AddressDto addressRead = readAddresstUseCase.readAddress(1L);

        verify(addressJpaGateway, times(1)).readAddress(1L);
        assertNotNull(addressRead);
        assertEquals(addressDto.id(), addressRead.id());
        assertEquals(addressDto.street(), addressRead.street());
        assertEquals(addressDto.email(), addressRead.email());
    }

    @Test
    void shouldReadAddressByIdPatient() {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa",
                "Catanduvas", "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 10L);
        when(addressJpaGateway.readAddressPatient(10L)).thenReturn(addressDto);

        AddressDto addressRead = readAddresstUseCase.readAddressPatient(10L);

        verify(addressJpaGateway, times(1)).readAddressPatient(10L);
        assertNotNull(addressRead);
        assertEquals(addressDto.idPatient(), addressRead.idPatient());
        assertEquals(addressDto.city(), addressRead.city());
        assertEquals(addressDto.zipCode(), addressRead.zipCode());
    }
}