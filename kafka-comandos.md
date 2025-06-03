


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
