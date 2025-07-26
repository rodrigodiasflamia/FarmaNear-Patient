package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteMedicationUseCaseTest {

    @Mock
    private IMedicationJpaGateway medicationJpaGateway;

    @InjectMocks
    private DeleteMedicationUseCase deleteMedicationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteMedication() {
        deleteMedicationUseCase.deleteMedication(1L);

        verify(medicationJpaGateway, times(1)).deleteMedication(1L);
    }
}