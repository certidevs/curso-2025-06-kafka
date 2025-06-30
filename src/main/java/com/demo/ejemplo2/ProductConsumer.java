package com.demo.ejemplo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumer para consumir objetos Product
 *
 * 2 opciones:
 *
 * - Lo recibe como texto String y lo convierte a objeto usando ObjectMapper
 * - Lo recibe como objeto Product usando JsonDeserializer
 */
@Component
public class ProductConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "products")
    public void consumirProducto(ConsumerRecord<String, String> mensaje) {
        String productJSON = mensaje.value();

        try {
            Product product = objectMapper.readValue(productJSON, Product.class);
            System.out.println("recibido mensaje de Kafka: " + productJSON);
            System.out.println(product);
            System.out.println("Título del producto: " + product.title());
            System.out.println("Precio del producto: " + product.price());
        } catch (JsonProcessingException e) {
            System.out.println("Error al procesar el producto: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "products2")
    public void consumirProducto2(ConsumerRecord<String, Product> mensaje) {

        Product product = mensaje.value();
        System.out.println("Título del producto: " + product.title());
        System.out.println("Precio del producto: " + product.price());
    }
}
