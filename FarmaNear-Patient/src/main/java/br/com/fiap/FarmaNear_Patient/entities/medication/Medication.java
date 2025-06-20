package br.com.fiap.FarmaNear_Patient.entities.medication;

import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;

import java.time.LocalDate;

public class Medication implements MedicationEntityInterface{

    private Long id;
    private String name;
    private String dosage;
    private String administrationRoute;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String notes;

    public Medication() { }

    public Medication(String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes) {
        this.name = name;
        this.dosage = dosage;
        this.administrationRoute = administrationRoute;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public Medication(Long id, String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.administrationRoute = administrationRoute;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public String getAdministrationRoute() {
        return administrationRoute;
    }

    public String getFrequency() {
        return frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public MedicationEntity createMedicationEntity() {
        return new MedicationEntity(name, dosage, administrationRoute, frequency, startDate, endDate, notes);
    }
}