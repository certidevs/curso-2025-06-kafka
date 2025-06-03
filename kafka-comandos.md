


En caso de descargar [Apache Kafka manualmente](https://kafka.apache.org/downloads) sin docker, se puede arrancar el entorno con los siguientes comandos.

Asegurarse de tener Java descargado y añadido en el Path y como variable de entorno.

Asegurarse de ejecutar los comandos con cmds distintas y con permisos de administrador.

```shell

cd bin/windows

# Arrancar herramientas

# Ejecutar zookeeper en una cmd
zookeeper-server-start.bat ../../config/zookeeper.properties

# Ejecutar kafka en otra cmd
kafka-server-start.bat ../../config/server.properties


# Crear topic, debería aparecer Created topic mytopic. despues de ejecutar esto

kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

# Comprobar si existe

kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

# PRODUCER

kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092

# Escribir mensajes y salir con Ctrl + C


# CONSUMER

kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

```

El comando para crear un topic con 3 particiones y factor de replicación de 1

Crear topics:

```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic topic_name --create --partitions 3 --replication-factor 1
```

El comando para ver información del topic

```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic topic_name --describe
```

Y para listar los topics que hay creados en Kafka puedes usar el comando

```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --list
```


Producers:

```bash
kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic topic_name
```


Consumidores:

Para leer a través de la línea de comandos la información de un topic puedes ejecutar la siguiente instrucción:

```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic topic_name --create --partitions 3 --replication-factor 1
```

Esto leerá solo la información que llegue a partir de ese momento, si quieres leer la información que hay desde el principio ejecuta:

```bash
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic topic_name --from-beginning
```

