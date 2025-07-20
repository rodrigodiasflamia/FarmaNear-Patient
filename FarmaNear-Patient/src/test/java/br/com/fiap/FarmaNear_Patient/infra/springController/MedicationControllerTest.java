package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.medication.CreateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.DeleteMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.ReadMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.UpdateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.utils.JsonFormatUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MedicationControllerTest {

    @Mock
    private MedicationController medicationController;

    @Mock
    private CreateMedicationController createMedicationController;

    @Mock
    private ReadMedicationController readMedicationController;

    @Mock
    private UpdateMedicationController updateMedicationController;

    @Mock
    private DeleteMedicationController deleteMedicationController;

    private MockMvc mockMvc;
    private AutoCloseable mock;

    @BeforeEach
    public void setUp(){
        mock = MockitoAnnotations.openMocks(this);
        medicationController = new MedicationController(createMedicationController, readMedicationController, updateMedicationController, deleteMedicationController);

        mockMvc = MockMvcBuilders
                .standaloneSetup(medicationController)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    public void shouldCreateMedication() throws Exception {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);
        when(createMedicationController.createMedication(medicationDto)).thenReturn(medicationDto);

        mockMvc.perform(post("/medication/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(medicationDto))
        ).andExpect(status().isOk());

        verify(createMedicationController, times(1) ).createMedication(medicationDto);
    }

    @Test
    public void shouldReadMedication() throws Exception {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);
        when(readMedicationController.readMedication(1L)).thenReturn(medicationDto);

        mockMvc.perform(get("/medication/read/{medicationId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        verify(readMedicationController, times(1)).readMedication(1L);
    }

    @Test
    public void shouldNotReadMedication() throws Exception {
        when(readMedicationController.readMedication(99L)).thenThrow(new RuntimeException("Medication not found"));
    }

    @Test
    public void shouldReadMedicationPatient() throws Exception {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);
        when(readMedicationController.readMedicationPatient(1L)).thenReturn(Collections.singletonList(medicationDto));

        mockMvc.perform(get("/medication/patient/read/{patientId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        verify(readMedicationController, times(1)).readMedicationPatient(1L);
    }

    @Test
    public void shouldNotReadMedicationPatient() throws Exception {
        when(readMedicationController.readMedicationPatient(99L)).thenThrow(new RuntimeException("Medication not found"));
    }

    @Test
    public void shoudUpdateMedication() throws Exception {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);
        when(updateMedicationController.updateMedication(medicationDto)).thenReturn(medicationDto);

        mockMvc.perform(put("/medication/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(medicationDto))
        ).andExpect(status().isOk());

        verify(updateMedicationController, times(1) ).updateMedication(medicationDto);
    }

    @Test
    public void shoudNotUpdateMedication() throws Exception {
        MedicationDto medicationDto = new MedicationDto(1L, "Paracetamol", "500mg", "Oral", "A cada 6 horas", LocalDate.parse("2025-06-20"), LocalDate.parse("2025-06-25"),
                "Tomar após as refeições. Não exceder 4 doses por dia.", 1L);
        when(updateMedicationController.updateMedication(medicationDto)).thenThrow(new RuntimeException("Medication not found"));
    }

    @Test
    public void shouldDeleteMedication() throws Exception {
        mockMvc.perform(delete("/medication/delete/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Medication successfully deleted!"));

        verify(deleteMedicationController, times(1)).deleteMedication(1L);
        verifyNoMoreInteractions(deleteMedicationController);
    }
}