package br.com.fiap.FarmaNear_Patient.infra.springController;

import br.com.fiap.FarmaNear_Patient.controller.patient.CreatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.DeletePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.ReadPatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.UpdatePatientController;
import br.com.fiap.FarmaNear_Patient.controller.patient.dto.PatientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final CreatePatientController createPatientController;
    private final ReadPatientController readPatientController;
    private final UpdatePatientController updatePatientController;
    private final DeletePatientController deletePatientController;
    
    public PatientController(CreatePatientController createPatientController,
                             ReadPatientController readPatientController,
                             UpdatePatientController updatePatientController,
                             DeletePatientController deletePatientController) {
        this.createPatientController = createPatientController;
        this.readPatientController = readPatientController;
        this.updatePatientController = updatePatientController;
        this.deletePatientController = deletePatientController;
    }

    @PostMapping(value="/create")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        PatientDto patientSaved = createPatientController.createPatient(patientDto);
        return ResponseEntity.ok().body(patientSaved);
    }

    @GetMapping(value="/read/{patientId}")
    public ResponseEntity<PatientDto> readPatient(@PathVariable Long patientId) {
        PatientDto patient = readPatientController.readPatient(patientId);
        return ResponseEntity.ok().body(patient);
    }

    @PutMapping(value="/update")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
        PatientDto patientUpdated = updatePatientController.updatePatient(patientDto);
        return ResponseEntity.ok().body(patientUpdated);
    }

    @DeleteMapping(value="/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        deletePatientController.deletePatient(patientId);
        return ResponseEntity.ok("Patient successfully deleted!");
    }
}