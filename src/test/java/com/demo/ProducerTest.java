package com.demo;

import org.apache.kafka.clients.producer.KafkaProducer; // sdk client de apache kafka para java
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class ProducerTest {


    @Test
    void ejemploProducerHolaMundo() {

        // Vamos a crear un Producer y enviar un mensaje hola mundo a Apache Kafka

        // Properties: propiedades de conexión a Apache Kafka

        // KafkaProducer: esto es un producer

        // ProducerRecord: esto es un mensaje que enviará el Producer

        // Lista de todas las propiedades de configuración: https://kafka.apache.org/documentation/#configuration

        // 1. CREAR CONFIGURACIÓN
        Properties properties = new Properties();
        //properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty("bootstrap.servers", "http://localhost:9092");
        // properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 2. CREAR PRODUCER
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // 3. CREAR UN MENSAJE
        ProducerRecord<String, String> recordMessage = new ProducerRecord<>("topic_2", "Hola desde Java");

        // 4. ENVIAR MENSAJE A APACHE KAFKA
        producer.send(recordMessage);
        // Cada vez que se envía un mensaje se genera un offset en apache kafka único para ese mensaje
        // el offset hemos comprobar que es auto incremental y no se resetea si borramos mensajes

        // 5. CERRAR EL PRODUCER
        producer.close();
    }
}
