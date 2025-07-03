package br.com.fiap.FarmaNear_Patient.infra.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(value = """
        select * from addresses a where a.id_patient = :patientId
    """, nativeQuery = true)
    Optional<AddressEntity> readAddressPatient(Long patientId);
}