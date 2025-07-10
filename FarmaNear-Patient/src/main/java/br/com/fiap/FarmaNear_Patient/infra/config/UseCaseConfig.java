package br.com.fiap.FarmaNear_Patient.infra.config;

import br.com.fiap.FarmaNear_Patient.interfaces.IAddressJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
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
public class UseCaseConfig {

    @Bean
    CreatePatientUseCase createPatientUseCase(IPatientJpaGateway patientJpaGateway) {
        return new CreatePatientUseCase(patientJpaGateway);
    }

    @Bean
    ReadPatientUseCase readPatientUseCase(IPatientJpaGateway patientJpaGateway) {
        return new ReadPatientUseCase(patientJpaGateway);
    }

    @Bean
    UpdatePatientUseCase updatePatientUseCase(IPatientJpaGateway patientJpaGateway) {
        return new UpdatePatientUseCase(patientJpaGateway);
    }

    @Bean
    DeletePatientUseCase deletePatientUseCase(IPatientJpaGateway patientJpaGateway) {
        return new DeletePatientUseCase(patientJpaGateway);
    }

    @Bean
    CreateAddresstUseCase createAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        return new CreateAddresstUseCase(addressJpaGateway);
    }

    @Bean
    ReadAddresstUseCase readAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        return new ReadAddresstUseCase(addressJpaGateway);
    }

    @Bean
    UpdateAddresstUseCase updateAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        return new UpdateAddresstUseCase(addressJpaGateway);
    }

    @Bean
    DeleteAddresstUseCase deleteAddresstUseCase(IAddressJpaGateway addressJpaGateway) {
        return new DeleteAddresstUseCase(addressJpaGateway);
    }

    @Bean
    CreateMedicationUseCase createMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        return new CreateMedicationUseCase(medicationJpaGateway);
    }

    @Bean
    ReadMedicationUseCase readMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        return new ReadMedicationUseCase(medicationJpaGateway);
    }

    @Bean
    UpdateMedicationUseCase updateMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        return new UpdateMedicationUseCase(medicationJpaGateway);
    }

    @Bean
    DeleteMedicationUseCase deleteMedicationUseCase(IMedicationJpaGateway medicationJpaGateway) {
        return new DeleteMedicationUseCase(medicationJpaGateway);
    }
}