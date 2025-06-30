package com.demo.ejemplo1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Clase consumer para consumir mensajes String Hola mundo de Kafka
 */
@Component
public class HelloConsumer {

    @KafkaListener(topics = "topic_spring")
    public void consumirMensaje(ConsumerRecord<String, String> mensaje) {
        System.out.println("recibido mensaje de Kafka: " + mensaje.value());
    }
}
