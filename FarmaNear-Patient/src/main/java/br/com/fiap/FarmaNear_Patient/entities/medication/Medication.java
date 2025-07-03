package br.com.fiap.FarmaNear_Patient.entities.medication;

import br.com.fiap.FarmaNear_Patient.entities.patient.Patient;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;

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
    private Patient patient;

    public Medication() { }

    public Medication(String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes, Patient patient) {
        this.name = name;
        this.dosage = dosage;
        this.administrationRoute = administrationRoute;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.patient = patient;
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

    public Patient getPatient() {
        return patient;
    }

    @Override
    public MedicationEntity createMedicationEntity() {
        PatientEntity patientEntity = new PatientEntity(patient.getId(), patient.getName(), patient.getCpf());
        return new MedicationEntity(name, dosage, administrationRoute, frequency, startDate, endDate, notes, patientEntity);
    }
}