package com.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // @KafkaListener(topics = "topic_spring", groupId = "group_spring")
    @KafkaListener(topics = "topic_spring")
    public void consumirMensaje(ConsumerRecord<String, String> mensaje) {

        System.out.println("recibido mensaje de Kafka: " + mensaje.value());
        // lógica de negocio
    }
}
