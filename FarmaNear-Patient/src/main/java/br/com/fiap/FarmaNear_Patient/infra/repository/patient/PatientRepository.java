package br.com.fiap.FarmaNear_Patient.infra.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> { }