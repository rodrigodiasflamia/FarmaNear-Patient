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

public class UpdateMedicationUseCaseTest {

    @Mock
    private IMedicationJpaGateway medicationJpaGateway;

    @InjectMocks
    private UpdateMedicationUseCase updateMedicationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdateMedication() {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"),
                LocalDate.parse("2025-06-25"), "Tomar após as refeições. Não ingerir com álcool.", 1L);
        when(medicationJpaGateway.updateMedication(medicationDto)).thenReturn(medicationDto);

        MedicationDto medicationUpdated = updateMedicationUseCase.updateMedication(medicationDto);

        verify(medicationJpaGateway, times(1)).updateMedication(medicationDto);
        assertNotNull(medicationUpdated);
        assertEquals(medicationDto.name(), medicationUpdated.name());
        assertEquals(medicationDto.dosage(), medicationUpdated.dosage());
        assertEquals(medicationDto.administrationRoute(), medicationUpdated.administrationRoute());
        assertEquals(medicationDto.frequency(), medicationUpdated.frequency());
        assertEquals(medicationDto.startDate(), medicationUpdated.startDate());
        assertEquals(medicationDto.endDate(), medicationUpdated.endDate());
        assertEquals(medicationDto.notes(), medicationUpdated.notes());
    }
}