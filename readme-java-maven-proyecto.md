
Si se tiene problemas con Spring Boot una alternativa es crear un proyecto java normal.


1. New
2. Java maven
3. Añadir dependencia Kafka en el pom.xml:


```xml
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-clients</artifactId>
    <version>3.9.1</version>
</dependency>
```