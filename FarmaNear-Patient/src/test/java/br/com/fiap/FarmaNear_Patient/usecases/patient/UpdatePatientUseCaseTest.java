package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UpdatePatientUseCaseTest {

    @Mock
    private IPatientJpaGateway patientJpaGateway;

    @InjectMocks
    private UpdatePatientUseCase updatePatientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdatePatient() {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(patientJpaGateway.updatePatient(patientDto)).thenReturn(patientDto);

        PatientDto patientUpdated = updatePatientUseCase.updatePatient(patientDto);

        verify(patientJpaGateway, times(1)).updatePatient(patientDto);
        assertNotNull(patientUpdated);
        assertEquals(patientDto.id(), patientUpdated.id());
        assertEquals(patientDto.name(), patientUpdated.name());
        assertEquals(patientDto.cpf(), patientUpdated.cpf());
    }
}