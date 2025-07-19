package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientJpaRepositoryTest {

    @InjectMocks
    private PatientJpaRepository patientJpaRepository;

    @Mock
    private PatientRepository patientRepository;

    private PatientEntity patientEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patientEntity = new PatientEntity("Rodrigo Dias Flamia", "974.501.760-41");
    }

    @Test
    void shouldCreatePatient() {
        Mockito.when(patientRepository.save(Mockito.any(PatientEntity.class))).thenReturn(patientEntity);
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");

        PatientDto patientSaved = patientJpaRepository.createPatient(patientDto);

        assertEquals(patientDto.name(), patientSaved.name());
        assertEquals(patientDto.cpf(), patientSaved.cpf());
    }

    @Test
    void shouldReadPatientById() {
        Mockito.when(patientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(patientEntity));

        PatientDto patient = patientJpaRepository.readPatientById(1L);

        assertEquals(patientEntity.getName(), patient.name());
        assertEquals(patientEntity.getCpf(), patient.cpf());
    }

    @Test
    void shouldNotReadPatientById() {
        Mockito.when(patientRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            patientJpaRepository.readPatientById(99L);
        });

        assertEquals("Patient not found", thrown.getMessage());
    }

    @Test
    void shouldReadPatientByCpf() {
        Mockito.when(patientRepository.readPatientByCpf(Mockito.anyString())).thenReturn(Optional.of(patientEntity));

        PatientDto patient = patientJpaRepository.readPatientByCpf("974.501.760-41");

        assertEquals(patientEntity.getName(), patient.name());
        assertEquals(patientEntity.getCpf(), patient.cpf());
    }

    @Test
    void shouldNotReadPatientByCpf() {
        Mockito.when(patientRepository.readPatientByCpf("999.999.999-99")).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            patientJpaRepository.readPatientByCpf("999.999.999-99");
        });

        assertEquals("Patient not found", thrown.getMessage());
    }

    @Test
    void shouldUpdatePatient() {
        Mockito.when(patientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(patientEntity));
        Mockito.when(patientRepository.save(Mockito.any(PatientEntity.class))).thenReturn(patientEntity);
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "871.167.950-65");

        PatientDto patientSaved = patientJpaRepository.updatePatient(patientDto);

        Mockito.verify(patientRepository, Mockito.times(1)).save(Mockito.any(PatientEntity.class));
        assertEquals(patientDto.name(), patientSaved.name());
        assertEquals(patientDto.cpf(), patientSaved.cpf());
    }

    @Test
    void shouldDeletePatient() {
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));

        patientJpaRepository.deletePatient(1L);

        Mockito.verify(patientRepository, Mockito.times(1)).delete(patientEntity);
    }

    @Test
    void shouldNotDeletePatient() {
        Mockito.when(patientRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            patientJpaRepository.deletePatient(99L);
        });

        assertEquals("Patient not found", thrown.getMessage());
    }
}