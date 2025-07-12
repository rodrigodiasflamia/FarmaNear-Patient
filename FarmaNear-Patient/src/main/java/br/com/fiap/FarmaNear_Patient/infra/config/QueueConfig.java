package br.com.fiap.FarmaNear_Patient.infra.config;

import br.com.fiap.FarmaNear_Patient.controller.patient.dto.QueuePatientDto;
import br.com.fiap.FarmaNear_Patient.infra.gateway.QueueGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class QueueConfig {

    @Bean
    public QueueGateway queueGateway(KafkaTemplate<String, QueuePatientDto> kafkaTemplate) {
        return new QueueGateway(kafkaTemplate);
    }
}