package br.com.fiap.FarmaNear_Patient.entities.patient;

import br.com.fiap.FarmaNear_Patient.entities.address.Address;
import br.com.fiap.FarmaNear_Patient.entities.medication.Medication;
import br.com.fiap.FarmaNear_Patient.infra.repository.patient.PatientEntity;

import java.util.Set;

public class Patient implements PatientEntityInterface{

    private Long id;
    private String name;
    private String cpf;

    public Patient() { }

    public Patient(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Patient(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public PatientEntity createPatientEntity(){
        return new PatientEntity(name, cpf);
    }
}