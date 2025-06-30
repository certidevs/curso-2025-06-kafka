# Curso Apache Kafka

Curso de Apache Kafka con Java y Spring Boot.

## Entorno de desarrollo IDE:

IntelliJ IDEA Community:

https://www.jetbrains.com/es-es/idea/download/?section=windows

## Crear un proyecto con Spring Boot Initializr

Descargar y descomprimir este proyecto:

https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.0&packaging=jar&jvmVersion=24&groupId=com.demo&artifactId=kafka&name=kafka&description=Demo%20Apache%20Kafka%20Spring%20Boot&packageName=com.demo&dependencies=web,kafka

Abrirlo con IntelliJ IDEA.

## Seleccionar JDK

IntelliJ IDEA permite descargar y seleccionar JDK.

* File
* Project Structure
* SDK descargar o seleccionar versión de Java 24.

En caso de usar Visual Studio Code:

* Extensiones para Java y Spring Boot:
  * Extension Pack for Java
  * Spring Initializr Java Support

## Instalación de Apache Kafka

Para conectar a Apache Kafka desde código ya sea Python o Java o Scala o cualquier lenguaje es necesario primero tener un Apache Kafka en ejecución.

* Opción 1:
  * Descargar los binarios y ejecutar manualmente los bat
  * https://kafka.apache.org/downloads

* Opción 2:
  * Iniciar kafka con docker
  * Desde linux-Mac habitual instalar docker engine: https://docs.docker.com/engine/install/ubuntu/
  * Desde Windows: https://docs.docker.com/desktop/setup/install/windows-install/
  * Utilizar docker compose para levantar un apache kafka con un comando:
    * https://github.com/confluentinc/cp-all-in-one/blob/7.9.0-post/cp-all-in-one/docker-compose.yml
    * docker-compose up -d

## INICIAR APACHE KAFKA

docker ps

docker-compose up -d

docker-compose down

docker stats

## Ver Apache Kafka

Opción 1: Control Center:
* Al arrancar con docker, tenemos un control-center que es una herramienta visual para entrar a Kafka:
* Entrar desde navegador: http://localhost:9021/clusters

* Opción 2: IntelliJ IDEA Ultimate:
  * Tiene un plugin oficial de JetBrains para conectar a Kafka y crear topics, producer, consumer

* Opción 3: 
* Visual Studio Code extension linjun.kafka-support

* Opción 4:
  *  simplemente conectarse desde código Java o Python


## CONCEPTOS DE APACHE KAFKA

### BROKER

Máquina o nodo donde se ejecuta el servicio de Apache Kafka. Es el servidor que forma parte de un clúster de Kafka.

Se encarga de recibir, almacenar y distribuir mensajes.

### CLUSTER

Para alta escalabilidad y disponibilidad es habitual tener más de un broker, lo cual conforma un clúster.

Conjunto de uno o varios brokers que trabajan juntos, para asegurar escalar la capacidad de envío y recepción de mensajes y alta disponibilidad.

### TOPICS

Un topic es la estructura de datos que utiliza Apache Kafka y actúa como una tabla donde se almacena la información y se consume la información.

Actúa como si fuera una tabla.

Los topics internamente tienen a nivel de configuración:

* particiones
* réplicas
* Tiempo de retención
* Política de limpieza

Hemos creado un topic llamado topic_1 desde control-center en http://localhost:9021/clusters

### PRODUCERS

Producer consiste en "producir" y enviar información a el broker para que la almacene en un topic.

Se puede crear un Producer desde:

* Código java o python
* Desde una aplicación como control-center
* Desde consola con un comando

La información puede ser:

* string
* número
* json
* schema apache avro

Vamos a probar a enviar datos desde control-center a un topic.

A cada mensaje se le asocia:
* value
* key
* timestamp
* headers
* partition
* offset: indica la posición del mensaje, útil para que los consumidores sepan desde donde leer

Símil: es como insertar una fila en una tabla de MySQL.

### RECORD O MENSAJE

Es el mensaje que un Producer envía a un topic de Apache Kafka.

Sería como una nueva fila en base de datos.

### CONSUMER

Consumer o consumidor lee los mensajes que llegan a un topic o varios topics.

### OFFSET

índice numérico que identifica la posición de un mensaje o record dentro de una partición dentro de un topic.

Permite al consumer saber qué mensajes ya procesó y desde donde continuar leyendo en caso de reinicio.


## APACHE KAFKA DESDE JAVA

Hemos creado en Java:

* ProducerTest: con el código mínimo necesario de Java para conectarse a Kafka y enviar un mensaje.

* ConsumerTest: con el código mínimo necesario de Java para conectarse a Kafka y recibir mensajes de kafka.

## APACHE KAFKA DESDE SPRING BOOT

https://docs.spring.io/spring-kafka/reference/kafka.html

* docker-compose up -d
* Control Center: http://localhost:9021
* Iniciar aplicación Spring Boot ejecutando el main de la clase KafkaApplication
* Aplicación Spring Boot: http://localhost:8080 

Crear un producer en Spring Boot para enviar mensajes a Apache Kafka:

* Paso 1:
  * Configurar producer en application.properties
* Paso 2:
  * Crear un controlador para poder invocarlo desde el navegador por HTTP
* Paso 3:
  * Inyectado KafkaTemplate en el controlador para poder enviar mensaje a Kafka


Crear un consumer en Spring Boot para recibir mensajes de Apache Kafka.

* Paso 1:
  *  Configurar consumer en application.properties
* Paso 2:
  * Crear clase Consumer con método para consumir mensajes de Apache Kafka
* Paso 3:
  * Enviar mensaje con el Producer y ver cómo el consumer lo recibe y lo imprime por consola

Pendiente:

* Enviar y recibir un objeto: Customer, Pedido, Transacción


## OPEN API SWAGGER

Agregada dependencia springdoc-openapi-starter-webmvc-ui en el pom.xml y recargar maven.

Ejecutar la aplicación de spring boot.

http://localhost:8080/swagger-ui/index.html

## ENVIAR JSON A KAFKA

Enviar un String con un solo valor es poco práctico, habitualmente se suele enviar un objeto entero.

### OPCIÓN 1: (DONE)

Enviar String con un json, y convertir de String a objeto java y viceversa con Jackson.

Para ello se puede usar ObjectMapper:

* writeValueAsString
* readValue

### OPCIÓN 2: 

* En application.properties cambiar Serializadores y Deserializadores por JSON 