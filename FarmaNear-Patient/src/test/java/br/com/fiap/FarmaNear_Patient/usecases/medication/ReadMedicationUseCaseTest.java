package br.com.fiap.FarmaNear_Patient.usecases.medication;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReadMedicationUseCaseTest {

    @Mock
    private IMedicationJpaGateway medicationJpaGateway;

    @InjectMocks
    private ReadMedicationUseCase readMedicationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReadMedicationById() {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"),
                LocalDate.parse("2025-06-25"), "Tomar após as refeições. Não ingerir com álcool.", 1L);
        when(medicationJpaGateway.readMedication(1L)).thenReturn(medicationDto);

        MedicationDto medicationRead = readMedicationUseCase.readMedication(1L);

        verify(medicationJpaGateway, times(1)).readMedication(1L);
        assertNotNull(medicationRead);
        assertEquals(medicationDto.id(), medicationRead.id());
        assertEquals(medicationDto.name(), medicationRead.name());
    }

    @Test
    void shouldReadMedicationsByPatientId() {
        MedicationDto firstMedication = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"),
                LocalDate.parse("2025-06-25"), "Tomar após as refeições. Não ingerir com álcool.", 1L);
        MedicationDto secondMedication = new MedicationDto(1L, "Omeprazol", "20mg", "Oral", "Uma vez ao dia", LocalDate.parse("2025-06-15"),
                LocalDate.parse("2025-06-30"), "Tomar em jejum, 30 minutos antes do café da manhã.", 1L);
        when(medicationJpaGateway.readMedicationPatient(1L)).thenReturn(List.of(firstMedication, secondMedication));

        List<MedicationDto> medicationRead = readMedicationUseCase.readMedicationPatient(1L);

        verify(medicationJpaGateway, times(1)).readMedicationPatient(1L);
        assertNotNull(medicationRead);
        assertEquals(2, medicationRead.size());
        assertEquals(firstMedication.name(), medicationRead.get(0).name());
        assertEquals(firstMedication.dosage(), medicationRead.get(0).dosage());
        assertEquals(firstMedication.administrationRoute(), medicationRead.get(0).administrationRoute());
        assertEquals(firstMedication.frequency(), medicationRead.get(0).frequency());
        assertEquals(firstMedication.startDate(), medicationRead.get(0).startDate());
        assertEquals(firstMedication.endDate(), medicationRead.get(0).endDate());
        assertEquals(firstMedication.notes(), medicationRead.get(0).notes());
        assertEquals(secondMedication.name(), medicationRead.get(1).name());
        assertEquals(secondMedication.dosage(), medicationRead.get(1).dosage());
        assertEquals(secondMedication.administrationRoute(), medicationRead.get(1).administrationRoute());
        assertEquals(secondMedication.frequency(), medicationRead.get(1).frequency());
        assertEquals(secondMedication.startDate(), medicationRead.get(1).startDate());
        assertEquals(secondMedication.endDate(), medicationRead.get(1).endDate());
        assertEquals(secondMedication.notes(), medicationRead.get(1).notes());
    }
}