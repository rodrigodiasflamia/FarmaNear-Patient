package br.com.fiap.FarmaNear_Patient.infra.gateway;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.QueuePatientDto;
import br.com.fiap.FarmaNear_Patient.interfaces.IQueueGateway;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class QueueGateway implements IQueueGateway {

    private final KafkaTemplate<String, QueuePatientDto> kafkaTemplate;

    public QueueGateway(KafkaTemplate<String, QueuePatientDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPatientToQueue(QueuePatientDto queueDrugstoreDto) {
        try{
            Future<?> future = kafkaTemplate.send("patient-data", queueDrugstoreDto);
            future.get();
        }catch(ExecutionException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}