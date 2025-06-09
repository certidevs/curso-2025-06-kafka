package com.demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumerTest {


    @Test
    void consumidor1() {

        // 1. PROPERTIES para el consumer
        // properties = Properties()
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group1");


        // 2. CREAR EL CONSUMER
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 3. SUSCRIBIRSE A UN TOPIC
        consumer.subscribe(List.of("topic_2")); // me puedo suscribir a varios topics

        // 4. LEER MENSAJES DE APACHE KAFKA CON EL CONSUMER
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));

            for (ConsumerRecord<String, String> record : records) { // for record in records:
                System.out.println(record.value()); // imprime mensaje

            }
        }

        // Normalmente la gestión del consumer
        // se hará con spring boot usando un Kafka Listener o utilidades de spring para leer


    }
}
