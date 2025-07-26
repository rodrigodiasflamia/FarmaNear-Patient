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

public class CreatePatientUseCaseTest {

    @Mock
    private IPatientJpaGateway patientJpaGateway;

    @InjectMocks
    private CreatePatientUseCase createPatientUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreatePatient() {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(patientJpaGateway.createPatient(patientDto)).thenReturn(patientDto);

        PatientDto patientCreated = createPatientUseCase.createPatient(patientDto);

        verify(patientJpaGateway, times(1)).createPatient(patientDto);
        assertNotNull(patientCreated);
        assertEquals(patientDto.name(), patientCreated.name());
        assertEquals(patientDto.cpf(), patientCreated.cpf());
        assertEquals(patientDto.id(), patientCreated.id());
    }
}