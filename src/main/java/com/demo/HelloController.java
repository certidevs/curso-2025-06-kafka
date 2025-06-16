package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> producer;

    // http://localhost:8080
    @GetMapping
    public String hola() {
        return "Hola";
    }

    // http://localhost:8080/producto
    @GetMapping("producto")
    public Product obtenerProduct() {
        return new Product("Silla Steelcase", 499.0);
    }

    // http://localhost:8080/enviar-mensaje
    @GetMapping("enviar-mensaje")
    public String enviarMensajeAKafka() {
        producer.sendDefault("Hola desde Spring Boot");
        return "Mensaje enviado";
    }




    /*
    OK 1. Crear un controlador
    NO 2. Agregar un Servicio, otra clase de java que tenga la lógica de negocio
    NO 3. Agregar un Repositorio, permite realizar consultas y guardados en base de datos
    SI 4. Agregar un Producer de Kafka para enviar mensajes a kafka



     */
}
