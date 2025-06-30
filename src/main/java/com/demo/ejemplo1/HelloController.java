package com.demo.ejemplo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que tiene un producer que envía un String hola mundo a Kafka
 */
@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> producer;

    @GetMapping
    public String hola() {
        return "Hola";
    }

    @GetMapping("enviar-mensaje/{mensaje}")
    public String enviarMensajeAKafka(@PathVariable String mensaje) {
        producer.sendDefault(mensaje);
        return "Mensaje enviado con éxito: " + mensaje;
    }

}
