package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.address.CreateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.ReadAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.UpdateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.DeleteAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final CreateAddressController createAddressController;
    private final ReadAddressController readAddressController;
    private final UpdateAddressController updateAddressController;
    private final DeleteAddressController deleteAddressController;

    public AddressController(CreateAddressController createAddressController,
                             ReadAddressController readAddressController1,
                             UpdateAddressController updateAddressController,
                             DeleteAddressController deleteAddressController) {
        this.createAddressController = createAddressController;
        this.readAddressController = readAddressController1;
        this.updateAddressController = updateAddressController;
        this.deleteAddressController = deleteAddressController;
    }

    @Operation(summary = "Cria o cadastro do endereço",
            description = "Cria o cadastro do endereço com street, number, neighborhood, complement, city, state, zipCode, mobilePhone e email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso!")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto addressSaved = createAddressController.createAddress(addressDto);
        return ResponseEntity.ok().body(addressSaved);
    }

    @Operation(summary = "Busca o cadastro do endereço",
               description = "Retorna o cadastro do endereço com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do endereço encontrado com sucesso!")
    })
    @GetMapping(value = "/read/{addressId}")
    public ResponseEntity<AddressDto> readAddress(@PathVariable Long addressId){
        AddressDto addressDto = readAddressController.readAddress(addressId);
        return ResponseEntity.ok().body(addressDto);
    }

    @Operation(summary = "Atualiza o cadastro do endereço",
            description = "Retorna o cadastro do endereço atualizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do endereço atualizado com sucesso!")
    })
    @PutMapping(value = "/update")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto){
        AddressDto addressUpdated = updateAddressController.updateAddress(addressDto);
        return ResponseEntity.ok().body(addressUpdated);
    }

    @Operation(summary = "Remove o cadastro do endereço",
            description = "Remove o cadastro do endereço com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do endereço removido com sucesso!")
    })
    @DeleteMapping(value = "/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId){
        deleteAddressController.deleteAddress(addressId);
        return ResponseEntity.ok("Address successfully deleted!");
    }
}