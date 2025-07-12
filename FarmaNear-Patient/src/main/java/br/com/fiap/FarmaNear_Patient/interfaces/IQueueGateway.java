package br.com.fiap.FarmaNear_Patient.interfaces;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.QueuePatientDto;

public interface IQueueGateway {

    void sendPatientToQueue(QueuePatientDto queuePatientDto);
}