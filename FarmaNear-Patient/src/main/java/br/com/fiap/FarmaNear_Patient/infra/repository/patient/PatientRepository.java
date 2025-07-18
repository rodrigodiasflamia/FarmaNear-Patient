package br.com.fiap.FarmaNear_Patient.infra.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query(value = """
        select * from patients p where p.cpf = :patientCpf;
    """, nativeQuery = true)
    Optional<PatientEntity> readPatientByCpf(String patientCpf);
}