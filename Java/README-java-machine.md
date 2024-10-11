# Máquina Java

Esta subcarpeta contiene un conjunto de instrucciones para crear un contenedor que pueda ejecutar programas de Java.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**

   ```bash
   docker-compose up
   ```

   **Explicación**: Este comando descargará las imágenes necesarias, arrancará los contenedores y ejecutará la aplicación definida en `Main.java`.

### Volver a poner en marcha

Si deseas volver a probar tu aplicación con otros cambios, es necesario desmontar todo antes de reiniciar.

1. **Detener los contenedores y eliminar imágenes**

   ```bash
   docker-compose down --rmi all
   ```

## Explicación

#### Dockerfile

El archivo `Dockerfile` se utiliza para construir la imagen de la aplicación Java.

```Dockerfile
FROM openjdk:17-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /app

COPY ./src /app/src

CMD ["java", "src/Main.java"]
```

#### docker-compose.yml

El archivo `docker-compose.yml` define cómo se deben ejecutar los contenedores.

```yaml
services:
  java:
    build: .
    container_name: java-app
    stdin_open: true
    tty: true
```

##### Detalles de la configuración

- **Dockerfile**:
  - `FROM openjdk:17-jdk-alpine`: Utiliza una imagen base de Java 17.
  - `RUN apk add --no-cache bash`: Instala `bash` en la imagen.
  - `WORKDIR /app`: Establece el directorio de trabajo en el contenedor.
  - `COPY ./src /app/src`: Copia el código fuente al contenedor.
  - `CMD ["java", "src/Main.java"]`: Comando para ejecutar la aplicación Java.

- **docker-compose.yml**:
  - `services`: Define los servicios que se ejecutarán en el contenedor.
  - `java`: Nombre del servicio.
  - `build: .`: Indica que debe construir la imagen a partir del `Dockerfile` en el directorio actual.
  - `container_name: java-app`: Asigna un nombre al contenedor.
  - `stdin_open: true` y `tty: true`: Permiten la interacción con la consola.