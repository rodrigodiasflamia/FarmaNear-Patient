package br.com.fiap.FarmaNear_Patient.infra.repository.medication;

import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medications")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dosage;
    private String administrationRoute;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    public MedicationEntity() { }

    public MedicationEntity(String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes) {
        this.name = name;
        this.dosage = dosage;
        this.administrationRoute = administrationRoute;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public MedicationEntity(Long id, String name, String dosage, String administrationRoute, String frequency, LocalDate startDate, LocalDate endDate, String notes) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getAdministrationRoute() {
        return administrationRoute;
    }

    public void setAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}