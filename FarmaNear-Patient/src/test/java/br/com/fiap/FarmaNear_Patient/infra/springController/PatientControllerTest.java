package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.patient.CreatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.DeletePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.ReadPatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.UpdatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PatientControllerTest {

    @Mock
    private PatientController patientController;

    @Mock
    private CreatePatientController createPatientController;

    @Mock
    private ReadPatientController readPatientController;

    @Mock
    private UpdatePatientController updatePatientController;

    @Mock
    private DeletePatientController deletePatientController;

    private MockMvc mockMvc;
    private AutoCloseable mock;

    @BeforeEach
    public void setUp(){
        mock = MockitoAnnotations.openMocks(this);
        patientController = new PatientController(createPatientController, readPatientController, updatePatientController, deletePatientController);

        mockMvc = MockMvcBuilders
                .standaloneSetup(patientController)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    public void shouldCreatePatient() throws Exception {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(createPatientController.createPatient(patientDto)).thenReturn(patientDto);

        mockMvc.perform(post("/patient/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(patientDto))
        ).andExpect(status().isOk());

        verify(createPatientController, times(1) ).createPatient(patientDto);
    }

    @Test
    public void shouldReadPatientById() throws Exception {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(readPatientController.readPatientById(1L)).thenReturn(patientDto);

        mockMvc.perform(get("/patient/read/id/{patientId}",1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(readPatientController, times(1)).readPatientById(1L);
    }

    @Test
    public void shouldNotReadPatientById() throws Exception {
        when(readPatientController.readPatientById(99L)).thenThrow(new RuntimeException("Patient not found"));
    }

    @Test
    public void shouldReadPatientByCpf() throws Exception {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(readPatientController.readPatientByCpf("974.501.760-41")).thenReturn(patientDto);

        mockMvc.perform(get("/patient/read/cpf/{patientCpf}", "974.501.760-41")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(readPatientController, times(1)).readPatientByCpf("974.501.760-41");
    }

    @Test
    public void shouldNotReadPatientByCpf() throws Exception {
        when(readPatientController.readPatientByCpf("999.999.999-99")).thenThrow(new RuntimeException("Patient not found"));
    }

    @Test
    public void shouldUpdatePatient() throws Exception {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(updatePatientController.updatePatient(patientDto)).thenReturn(patientDto);

        mockMvc.perform(put("/patient/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(patientDto))
        ).andExpect(status().isOk());

        verify(updatePatientController, times(1) ).updatePatient(patientDto);
    }

    @Test
    public void shouldNotUpdatePatient() throws Exception {
        PatientDto patientDto = new PatientDto(1L, "Rodrigo Dias Flamia", "974.501.760-41");
        when(updatePatientController.updatePatient(patientDto)).thenThrow(new RuntimeException("Patient not found"));
    }

    @Test
    public void shouldDeletePatient() throws Exception {
        mockMvc.perform(delete("/patient/delete/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Patient successfully deleted!"));

        verify(deletePatientController, times(1)).deletePatient(1L);
        verifyNoMoreInteractions(deletePatientController);
    }
}