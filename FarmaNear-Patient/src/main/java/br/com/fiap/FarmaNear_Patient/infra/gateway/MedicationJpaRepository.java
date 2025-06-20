package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.medication.dto.MedicationDto;
import br.com.fiap.FarmaNear_Patient.entities.medication.Medication;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationRepository;
import br.com.fiap.FarmaNear_Patient.interfaces.IMedicationJpaGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MedicationJpaRepository implements IMedicationJpaGateway {

    private final MedicationRepository medicationRepository;

    public MedicationJpaRepository(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Transactional
    public MedicationDto createMedication(MedicationDto medicationDto) {
        Medication medication = new Medication(medicationDto.name(), medicationDto.dosage(), medicationDto.administrationRoute(), medicationDto.frequency(),
                medicationDto.startDate(), medicationDto.endDate(),  medicationDto.notes());
        MedicationEntity saved = medicationRepository.save(medication.createMedicationEntity());
        return new MedicationDto(saved.getId(), saved.getName(), saved.getDosage(), saved.getAdministrationRoute(), saved.getFrequency(), saved.getStartDate(),
                saved.getEndDate(), saved.getNotes());
    }

    @Transactional
    public MedicationDto readMedication(Long medicationId) {
        MedicationEntity medicationEntity = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        return new MedicationDto(medicationEntity.getId(), medicationEntity.getName(), medicationEntity.getDosage(), medicationEntity.getAdministrationRoute(),
                medicationEntity.getFrequency(), medicationEntity.getStartDate(), medicationEntity.getEndDate(), medicationEntity.getNotes());
    }

    @Transactional
    public MedicationDto updateMedication(MedicationDto medicationDto) {
        MedicationEntity medicationEntity = medicationRepository.findById(medicationDto.id())
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        medicationEntity.setName(medicationDto.name());
        medicationEntity.setDosage(medicationDto.dosage());
        medicationEntity.setAdministrationRoute(medicationDto.administrationRoute());
        medicationEntity.setFrequency(medicationDto.frequency());
        medicationEntity.setStartDate(medicationDto.startDate());
        medicationEntity.setEndDate(medicationDto.endDate());
        medicationEntity.setNotes(medicationDto.notes());

        MedicationEntity saved = medicationRepository.save(medicationEntity);
        return new MedicationDto(saved.getId(), saved.getName(), saved.getDosage(), saved.getAdministrationRoute(), saved.getFrequency(), saved.getStartDate(),
                saved.getEndDate(), saved.getNotes());
    }

    @Transactional
    public void deleteMedication(Long medicationId) {
        MedicationEntity medicationEntity = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        medicationRepository.delete(medicationEntity);
    }
}