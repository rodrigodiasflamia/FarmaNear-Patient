package br.com.fiap.FarmaNear_Patient.infra.repository.medication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> { }