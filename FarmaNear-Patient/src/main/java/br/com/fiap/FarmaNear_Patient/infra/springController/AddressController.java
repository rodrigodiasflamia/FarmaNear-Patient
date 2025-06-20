package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.address.CreateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.ReadAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.UpdateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.DeleteAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.dto.AddressDto;
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

    @PostMapping(value = "/create")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto addressSaved = createAddressController.createAddress(addressDto);
        return ResponseEntity.ok().body(addressSaved);
    }

    @GetMapping(value = "/read/{addressId}")
    public ResponseEntity<AddressDto> readAddress(@PathVariable Long addressId){
        AddressDto addressDto = readAddressController.readAddress(addressId);
        return ResponseEntity.ok().body(addressDto);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto){
        AddressDto addressUpdated = updateAddressController.updateAddress(addressDto);
        return ResponseEntity.ok().body(addressUpdated);
    }

    @DeleteMapping(value = "/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId){
        deleteAddressController.deleteAddress(addressId);
        return ResponseEntity.ok("Address successfully deleted!");
    }
}