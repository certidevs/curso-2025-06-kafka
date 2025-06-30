package com.demo.ejemplo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que recibe un objeto Product vía API REST y lo envía a Kafka
 *
 * 2 opciones:
 *
 * - Lo envía como texto usando ObjectMapper
 * - Lo envía como objeto usando JsonSerializer
 */
@RestController
public class ProductController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private KafkaTemplate<String, String> producer;
    @Autowired
    private KafkaTemplate<String, Product> productProducer;

    // http://localhost:8080/producto
    @GetMapping("producto")
    public Product obtenerProduct() {
        return new Product("Silla Steelcase", 499.0);
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
}
