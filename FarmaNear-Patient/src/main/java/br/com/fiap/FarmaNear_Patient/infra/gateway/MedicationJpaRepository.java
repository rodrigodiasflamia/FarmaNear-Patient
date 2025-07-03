package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.entities.medication.Medication;
import br.com.fiap.FarmaNear_Patient.entities.patient.Patient;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationRepository;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientRepository;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationJpaRepository implements IMedicationJpaGateway {

    private final MedicationRepository medicationRepository;
    private final PatientRepository patientRepository;

    public MedicationJpaRepository(MedicationRepository medicationRepository,
                                   PatientRepository patientRepository) {
        this.medicationRepository = medicationRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public MedicationDto createMedication(MedicationDto medicationDto) {
        PatientEntity patientEntity = patientRepository.findById(medicationDto.idPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Patient patient = new Patient(patientEntity.getId(), patientEntity.getName(), patientEntity.getCpf());

        Medication medication = new Medication(medicationDto.name(), medicationDto.dosage(), medicationDto.administrationRoute(), medicationDto.frequency(),
                medicationDto.startDate(), medicationDto.endDate(), medicationDto.notes(), patient);
        MedicationEntity saved = medicationRepository.save(medication.createMedicationEntity());
        return new MedicationDto(saved.getId(), saved.getName(), saved.getDosage(), saved.getAdministrationRoute(), saved.getFrequency(), saved.getStartDate(),
                saved.getEndDate(), saved.getNotes(), saved.getPatient().getId());
    }

    @Transactional
    public MedicationDto readMedication(Long medicationId) {
        MedicationEntity medicationEntity = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        return new MedicationDto(medicationEntity.getId(), medicationEntity.getName(), medicationEntity.getDosage(), medicationEntity.getAdministrationRoute(), medicationEntity
                .getFrequency(), medicationEntity.getStartDate(), medicationEntity.getEndDate(), medicationEntity.getNotes(), medicationEntity.getPatient().getId());
    }

    @Transactional
    public List<MedicationDto> readMedicationPatient(Long patientId){
        List<MedicationEntity> medicationEntities = medicationRepository.readMedicationPatient(patientId);
        if(medicationEntities.isEmpty()) {
            throw new RuntimeException("Medication not found");
        }

        List<MedicationDto> dtos = new ArrayList<>();
        medicationEntities.forEach(dto -> {
            MedicationDto medicationDto = new MedicationDto(dto.getId(), dto.getName(), dto.getDosage(), dto.getAdministrationRoute(),
                    dto.getFrequency(), dto.getStartDate(), dto.getEndDate(), dto.getNotes(), dto.getPatient().getId());
            dtos.add(medicationDto);
        });
        return dtos;
    }

    @Transactional
    public MedicationDto updateMedication(MedicationDto medicationDto) {
        PatientEntity patientEntity = patientRepository.findById(medicationDto.idPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        MedicationEntity medicationEntity = medicationRepository.findById(medicationDto.id())
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        medicationEntity.setName(medicationDto.name());
        medicationEntity.setDosage(medicationDto.dosage());
        medicationEntity.setAdministrationRoute(medicationDto.administrationRoute());
        medicationEntity.setFrequency(medicationDto.frequency());
        medicationEntity.setStartDate(medicationDto.startDate());
        medicationEntity.setEndDate(medicationDto.endDate());
        medicationEntity.setNotes(medicationDto.notes());
        medicationEntity.setPatient(patientEntity);

        MedicationEntity saved = medicationRepository.save(medicationEntity);
        return new MedicationDto(saved.getId(), saved.getName(), saved.getDosage(), saved.getAdministrationRoute(), saved.getFrequency(), saved.getStartDate(),
                saved.getEndDate(), saved.getNotes(), saved.getPatient().getId());
    }

    @Transactional
    public void deleteMedication(Long medicationId) {
        MedicationEntity medicationEntity = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        medicationRepository.delete(medicationEntity);
    }
}