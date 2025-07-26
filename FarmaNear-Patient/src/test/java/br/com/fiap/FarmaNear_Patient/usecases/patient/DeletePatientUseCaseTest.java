package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeletePatientUseCaseTest {

    @Mock
    private IPatientJpaGateway patientJpaGateway;

    @InjectMocks
    private DeletePatientUseCase deletePatientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeletePatient() {
       deletePatientUseCase.deletePatient(1L);

       verify(patientJpaGateway, times(1)).deletePatient(1L);
    }
}