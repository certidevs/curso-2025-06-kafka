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

Máquina o nodo donde se ejecuta el servicio de Apache Kafka.

### CLUSTER

Para alta escalabilidad y disponibilidad es habitual tener más de un broker, lo cual conforma un clúster.

### TOPICS

Un topic es la estructura de datos que utiliza Apache Kafka y actúa como una tabla donde se almacena la información y se consume la información.

Actúa como si fuera una tabla.

Los topics internamente tienen a nivel de configuración:

* particiones
* réplicas
* Tiempo de retención
* Política de limpieza

Hemos creado un topic llamado topic_1 desde control-center.

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

### CONSUMER

Consumer o consumidor lee los mensajes que llegan a un topic.

