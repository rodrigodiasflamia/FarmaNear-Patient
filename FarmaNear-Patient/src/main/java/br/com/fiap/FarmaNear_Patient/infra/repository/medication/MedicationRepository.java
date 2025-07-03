package br.com.fiap.FarmaNear_Patient.infra.repository.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {

    @Query(value = """
        select * from medications m where m.id_patient = :patientId;
    """, nativeQuery = true)
    List<MedicationEntity> readMedicationPatient(Long patientId);
}