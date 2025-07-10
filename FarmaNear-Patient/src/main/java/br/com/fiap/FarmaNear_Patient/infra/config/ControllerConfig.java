package br.com.fiap.FarmaNear_Patient.infra.config;

import br.com.fiap.FarmaNear_Patient.controller.address.CreateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.DeleteAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.ReadAddressController;
import br.com.fiap.FarmaNear_Patient.controller.address.UpdateAddressController;
import br.com.fiap.FarmaNear_Patient.controller.medication.CreateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.DeleteMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.ReadMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.medication.UpdateMedicationController;
import br.com.fiap.FarmaNear_Patient.controller.patient.CreatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.DeletePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.ReadPatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.UpdatePatientController;
import br.com.fiap.FarmaNear_Patient.usecases.address.CreateAddresstUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.address.DeleteAddresstUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.address.ReadAddresstUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.address.UpdateAddresstUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.medication.CreateMedicationUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.medication.DeleteMedicationUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.medication.ReadMedicationUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.medication.UpdateMedicationUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.patient.CreatePatientUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.patient.DeletePatientUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.patient.ReadPatientUseCase;
import br.com.fiap.FarmaNear_Patient.usecases.patient.UpdatePatientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    CreatePatientController createPatientController(CreatePatientUseCase createPatientUseCase) {
        return new CreatePatientController(createPatientUseCase);
    }

    @Bean
    ReadPatientController readPatientController(ReadPatientUseCase readPatientUseCase) {
        return new ReadPatientController(readPatientUseCase);
    }

    @Bean
    UpdatePatientController updatePatientController(UpdatePatientUseCase updatePatientUseCase) {
        return new UpdatePatientController(updatePatientUseCase);
    }

    @Bean
    DeletePatientController deletePatientController(DeletePatientUseCase deletePatientUseCase) {
        return new DeletePatientController(deletePatientUseCase);
    }

    @Bean
    CreateAddressController createAddressController(CreateAddresstUseCase createAddresstUseCase) {
        return new CreateAddressController(createAddresstUseCase);
    }

    @Bean
    ReadAddressController readAddressController(ReadAddresstUseCase readAddressController) {
        return new ReadAddressController(readAddressController);
    }

    @Bean
    UpdateAddressController updateAddressController(UpdateAddresstUseCase updateAddresstUseCase) {
        return new UpdateAddressController(updateAddresstUseCase);
    }

    @Bean
    DeleteAddressController deleteAddressController(DeleteAddresstUseCase deleteAddresstUseCase) {
        return new DeleteAddressController(deleteAddresstUseCase);
    }

    @Bean
    CreateMedicationController createMedicationController(CreateMedicationUseCase createMedicationUseCase) {
        return new CreateMedicationController(createMedicationUseCase);
    }

    @Bean
    ReadMedicationController readMedicationController(ReadMedicationUseCase readMedicationUseCase) {
        return new ReadMedicationController(readMedicationUseCase);
    }

    @Bean
    UpdateMedicationController updateMedicationController(UpdateMedicationUseCase updateMedicationUseCase) {
        return new UpdateMedicationController(updateMedicationUseCase);
    }

    @Bean
    DeleteMedicationController deleteMedicationController(DeleteMedicationUseCase deleteMedicationUseCase) {
        return new DeleteMedicationController(deleteMedicationUseCase);
    }
}