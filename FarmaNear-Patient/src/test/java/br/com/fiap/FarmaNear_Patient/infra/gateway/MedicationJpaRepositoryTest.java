package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationRepository;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicationJpaRepositoryTest {

    @InjectMocks
    private MedicationJpaRepository medicationJpaRepository;

    @Mock
    private MedicationRepository medicationRepository;

    @Mock
    private PatientRepository patientRepository;

    private PatientEntity patientEntity;

    private MedicationEntity medicationEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patientEntity = new PatientEntity("Rodrigo Dias Flamia", "974.501.760-41");
        medicationEntity = new MedicationEntity("Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", patientEntity);
    }

    @Test
    void shouldCreateMedication(){
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));
        Mockito.when(medicationRepository.save(Mockito.any(MedicationEntity.class))).thenReturn(medicationEntity);
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);

        MedicationDto medicationSaved = medicationJpaRepository.createMedication(medicationDto);

        assertEquals(medicationDto.name(), medicationSaved.name());
        assertEquals(medicationDto.dosage(), medicationSaved.dosage());
        assertEquals(medicationDto.administrationRoute(), medicationSaved.administrationRoute());
        assertEquals(medicationDto.frequency(), medicationSaved.frequency());
        assertEquals(medicationDto.startDate(), medicationSaved.startDate());
        assertEquals(medicationDto.endDate(), medicationSaved.endDate());
        assertEquals(medicationDto.notes(), medicationSaved.notes());
    }

    @Test
    void shouldReadMedication(){
        Mockito.when(medicationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(medicationEntity));

        MedicationDto medication = medicationJpaRepository.readMedication(1L);

        assertEquals(medicationEntity.getName(), medication.name());
        assertEquals(medicationEntity.getDosage(), medication.dosage());
        assertEquals(medicationEntity.getAdministrationRoute(), medication.administrationRoute());
        assertEquals(medicationEntity.getFrequency(), medication.frequency());
        assertEquals(medicationEntity.getStartDate(), medication.startDate());
        assertEquals(medicationEntity.getEndDate(), medication.endDate());
        assertEquals(medicationEntity.getNotes(), medication.notes());
    }

    @Test
    void shouldNotReadMedication(){
        Mockito.when(medicationRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            medicationJpaRepository.readMedication(99L);
        });

        assertEquals("Medication not found", thrown.getMessage());
    }

    @Test
    void shouldUpdateMedication(){
        Mockito.when(patientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(patientEntity));
        Mockito.when(medicationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(medicationEntity));
        Mockito.when(medicationRepository.save(Mockito.any(MedicationEntity.class))).thenReturn(medicationEntity);
        MedicationDto medicationDto = new MedicationDto(1L, "Amoxilina", "875mg", "Oral", "2 vezes ao dia", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar com um copo cheio de água. Não interromper o tratamento antes da data final.", 1L);

        MedicationDto medicationSaved = medicationJpaRepository.updateMedication(medicationDto);

        Mockito.verify(medicationRepository, Mockito.times(1)).save(Mockito.any(MedicationEntity.class));
        assertEquals(medicationDto.name(), medicationSaved.name());
        assertEquals(medicationDto.dosage(), medicationSaved.dosage());
        assertEquals(medicationDto.administrationRoute(), medicationSaved.administrationRoute());
        assertEquals(medicationDto.frequency(), medicationSaved.frequency());
        assertEquals(medicationDto.startDate(), medicationSaved.startDate());
        assertEquals(medicationDto.endDate(), medicationSaved.endDate());
        assertEquals(medicationDto.notes(), medicationSaved.notes());
    }

    @Test
    void shouldDeleteMedication(){
        Mockito.when(medicationRepository.findById(1L)).thenReturn(Optional.of(medicationEntity));

        medicationJpaRepository.deleteMedication(1L);

        Mockito.verify(medicationRepository, Mockito.times(1)).delete(medicationEntity);
    }

    @Test
    void shouldNotDeleteMedication(){
        Mockito.when(medicationRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            medicationJpaRepository.deleteMedication(99L);
        });

        assertEquals("Medication not found", thrown.getMessage());
    }
}