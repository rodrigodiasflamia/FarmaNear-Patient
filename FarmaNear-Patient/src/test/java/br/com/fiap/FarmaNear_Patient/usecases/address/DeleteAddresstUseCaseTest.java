package br.com.fiap.FarmaNear_Patient.usecases.address;

import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteAddresstUseCaseTest {

    @Mock
    private IAddressJpaGateway addressJpaGateway;

    @InjectMocks
    private DeleteAddresstUseCase deleteAddresstUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteAddress() {
        deleteAddresstUseCase.deleteAddress(1L);

        verify(addressJpaGateway, times(1)).deleteAddress(1L);
    }
}