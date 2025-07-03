package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import br.com.fiap.FarmaNear_Patient.entities.patient.Patient;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import br.com.fiap.FarmaNear_Patient.interfaces.IPatientJpaGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PatientJpaRepository implements IPatientJpaGateway {

    private final PatientRepository patientRepository;

    public PatientJpaRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = new Patient(patientDto.name(), patientDto.cpf());
        PatientEntity saved = patientRepository.save(patient.createPatientEntity());
        return new PatientDto(saved.getId(), saved.getName(), saved.getCpf());
    }

    @Transactional
    public PatientDto readPatient(Long patientId) {
        PatientEntity patientEntity = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return new PatientDto(patientEntity.getId(), patientEntity.getName(), patientEntity.getCpf());
    }

    @Transactional
    public PatientDto updatePatient(PatientDto patientDto) {
        PatientEntity patientEntity = patientRepository.findById(patientDto.id())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patientEntity.setName(patientDto.name());
        patientEntity.setCpf(patientDto.cpf());

        PatientEntity saved = patientRepository.save(patientEntity);
        return new PatientDto(saved.getId(), saved.getName(), saved.getCpf());
    }
    @Transactional
    public void deletePatient(Long patientId) {
        PatientEntity patientEntity = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patientRepository.delete(patientEntity);
    }
}
