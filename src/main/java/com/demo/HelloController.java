package com.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> producer;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private KafkaTemplate<String, Product> productProducer;


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
    @GetMapping("enviar-mensaje/{mensaje}")
    public String enviarMensajeAKafka(@PathVariable String mensaje) {
        producer.sendDefault(mensaje);
        return "Mensaje enviado con éxito: " + mensaje;
    }

    // POST http://localhost:8080/enviar-producto
    @PostMapping("enviar-producto")
    public Product enviarProductoAKafka(@RequestBody Product product) {
        // enviar a kafka un objeto producto
        System.out.println(product);
        // producer.sendDefault(product);

        try {
            String productJSON = objectMapper.writeValueAsString(product);
            producer.send("products", productJSON);
        } catch (JsonProcessingException e) {
            System.out.println("Error al enviar el producto: " + e.getMessage());
        }

        return product;
    }

    @PostMapping("enviar-producto2")
    public Product enviarProductoAKafka2(@RequestBody Product product) {
        productProducer.send("products2", product);
        return product;
    }

    // PostMapping

    /*
    OK 1. Crear un controlador
    NO 2. Agregar un Servicio, otra clase de java que tenga la lógica de negocio
    NO 3. Agregar un Repositorio, permite realizar consultas y guardados en base de datos
    SI 4. Agregar un Producer de Kafka para enviar mensajes a kafka



     */
}
