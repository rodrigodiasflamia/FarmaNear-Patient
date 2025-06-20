package br.com.fiap.FarmaNear_Patient.infra.repository.patient;

import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Patient.infra.repository.medication.MedicationEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicationEntity> medications;

    public PatientEntity() { }

    public PatientEntity(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public PatientEntity(String name, String cpf, AddressEntity address, Set<MedicationEntity> medications) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.medications = medications;
    }

    public PatientEntity(Long id, String name, String cpf, AddressEntity address, Set<MedicationEntity> medications) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.medications = medications;
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

    public Set<MedicationEntity> getMedications() {
        return medications;
    }

    public void setMedications(Set<MedicationEntity> medications) {
        this.medications = medications;
    }
}