package br.com.fiap.FarmaNear_Patient.usecases.patient;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadPatientUseCaseTest {

    @Mock
    private IPatientJpaGateway patientJpaGateway;

    @InjectMocks
    private ReadPatientUseCase readPatientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReadPatientById() {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(patientJpaGateway.readPatientById(1L)).thenReturn(patientDto);

        PatientDto patientRead  = readPatientUseCase.readPatientById(1L);

        verify(patientJpaGateway, times(1)).readPatientById(1L);
        assertNotNull(patientRead );
        assertEquals(patientDto.id(), patientRead.id());
        assertEquals(patientDto.name(), patientRead.name());
        assertEquals(patientDto.cpf(), patientRead.cpf());
    }

    @Test
    void shouldReadPatientByCpf() {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(patientJpaGateway.readPatientByCpf("974.501.760-41")).thenReturn(patientDto);

        PatientDto patientRead  = readPatientUseCase.readPatientByCpf("974.501.760-41");

        verify(patientJpaGateway, times(1)).readPatientByCpf("974.501.760-41");
        assertNotNull(patientRead );
        assertEquals(patientDto.id(), patientRead.id());
        assertEquals(patientDto.name(), patientRead.name());
        assertEquals(patientDto.cpf(), patientRead.cpf());
    }
}