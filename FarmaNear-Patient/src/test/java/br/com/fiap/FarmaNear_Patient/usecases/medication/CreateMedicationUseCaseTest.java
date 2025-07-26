package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateMedicationUseCaseTest {

    @Mock
    private IMedicationJpaGateway medicationJpaGateway;

    @InjectMocks
    private CreateMedicationUseCase createMedicationUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateMedication() {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"),
                LocalDate.parse("2025-06-25"), "Tomar após as refeições. Não ingerir com álcool.", 1L);
        when(medicationJpaGateway.createMedication(medicationDto)).thenReturn(medicationDto);

        MedicationDto medicationCreated = createMedicationUseCase.createMedication(medicationDto);

        verify(medicationJpaGateway, times(1)).createMedication(medicationDto);
        assertNotNull(medicationCreated);
        assertEquals(medicationDto.name(), medicationCreated.name());
        assertEquals(medicationDto.dosage(), medicationCreated.dosage());
        assertEquals(medicationDto.administrationRoute(), medicationCreated.administrationRoute());
        assertEquals(medicationDto.frequency(), medicationCreated.frequency());
        assertEquals(medicationDto.startDate(), medicationCreated.startDate());
        assertEquals(medicationDto.endDate(), medicationCreated.endDate());
        assertEquals(medicationDto.notes(), medicationCreated.notes());
        assertEquals(medicationDto.id(), medicationCreated.id());
    }
}