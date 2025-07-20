package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.address.CreateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.DeleteAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.ReadAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.UpdateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
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

public class AddressControllerTest {

    @Mock
    private AddressController addressController;

    @Mock
    private CreateAddressController createAddressController;

    @Mock
    private ReadAddressController readAddressController;

    @Mock
    private UpdateAddressController updateAddressController;

    @Mock
    private DeleteAddressController deleteAddressController;

    private MockMvc mockMvc;
    private AutoCloseable mock;

    @BeforeEach
    public void setUp(){
        mock = MockitoAnnotations.openMocks(this);
        addressController = new AddressController(createAddressController, readAddressController, updateAddressController, deleteAddressController);

        mockMvc = MockMvcBuilders
                .standaloneSetup(addressController)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    public void shouldCreateAddress() throws Exception {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);
        when(createAddressController.createAddress(addressDto)).thenReturn(addressDto);

        mockMvc.perform(post("/address/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(addressDto))
        ).andExpect(status().isOk());

        verify(createAddressController, times(1) ).createAddress(addressDto);
    }

    @Test
    public void shouldReadAddress() throws Exception{
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);
        when(readAddressController.readAddress(1L)).thenReturn(addressDto);

        mockMvc.perform(get("/address/read/{addressId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(readAddressController, times(1)).readAddress(1L);
    }

    @Test
    public void shouldNotReadAddress() throws Exception{
        when(readAddressController.readAddress(99L)).thenThrow(new RuntimeException("Address not found"));
    }

    @Test
    public void shouldReadAddressPatient() throws Exception{
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);
        when(readAddressController.readAddressPatient(1L)).thenReturn(addressDto);

        mockMvc.perform(get("/address/patient/read/{patientId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(readAddressController, times(1)).readAddressPatient(1L);
    }

    @Test
    public void shouldNotReadAddressPatient() throws Exception{
        when(readAddressController.readAddressPatient(99L)).thenThrow(new RuntimeException("Address not found"));
    }

    @Test
    public void shouldUpdateAddress() throws Exception {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);
        when(updateAddressController.updateAddress(addressDto)).thenReturn(addressDto);

        mockMvc.perform(put("/address/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(addressDto))
        ).andExpect(status().isOk());

        verify(updateAddressController, times(1) ).updateAddress(addressDto);
    }

    @Test
    public void shouldNotUpdateAddress() throws Exception {
        AddressDto addressDto = new AddressDto(1L, "Rua Nereu Ramos", "866", "Bairro Sayonara", "Casa", "Catanduvas",
                "SC", "89670-000", "(49) 98889-1297", "rodrigo.flamia@gmail.com", 1L);
        when(updateAddressController.updateAddress(addressDto)).thenThrow(new RuntimeException("Address not found"));
    }

    @Test
    public void shouldDeleteAddress() throws Exception {
        mockMvc.perform(delete("/address/delete/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Address successfully deleted!"));

        verify(deleteAddressController, times(1)).deleteAddress(1L);
        verifyNoMoreInteractions(deleteAddressController);
    }
}