package br.com.fiap.FarmaNear_Patient.infra.repository.patient;

import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressEntity address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationEntity> medications = new ArrayList<>();

    public PatientEntity() { }

    public PatientEntity(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public PatientEntity(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<MedicationEntity> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicationEntity> medications) {
        this.medications = medications;
    }
}