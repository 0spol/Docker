# MongoDB

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos MongoDB.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará la imagen de MongoDB, arrancará el contenedor y configurará el entorno para su uso.

### Acceso a MongoDB

- **URL de acceso**: MongoDB se ejecuta en `mongodb://localhost:27017`.
- **Credenciales**:
  - **Usuario**: `admin`
  - **Contraseña**: `admin123`
  
Puedes utilizar cualquier cliente MongoDB, como MongoDB Compass o la línea de comandos `mongo`, para conectarte usando estas credenciales.

Recomiendo usar **MongoSH** por línea de comandos.

  ```bash
   mongosh mongodb://admin:admin123@localhost:27017
   ```

Si usas IntelliJ o Visual Studio, también puedes descargar un plugin para facilitar la gestión de bases de datos. Para IntelliJ, se puede utilizar **Database Navigator**, y para Visual Studio, **MongoDB for VS Code**.

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se debe ejecutar el contenedor y su configuración específica.

```yaml
services:
  mongodb:
    image: mongo:latest
    container_name: mongodb_container
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD: admin123
    volumes:
      - mongodb_data:/data/db

volumes:
  mongodb_data:
```

### Detalles de la configuración

- **MongoDB**:
  - `image: mongo:latest`: Utiliza la última imagen de MongoDB.
  - `container_name: mongodb_container`: Asigna un nombre al contenedor de MongoDB.
  - `ports`: Mapea el puerto `27017` del contenedor al puerto `27017` de la máquina local, permitiendo conexiones desde el host.
  - `environment`: Define las variables de entorno necesarias para la configuración de la base de datos:
    - `MONGO_INITDB_ROOT_USERNAME`: Nombre de usuario para el administrador.
    - `MONGO_INITDB_ROOT_PASSWORD`: Contraseña para el administrador.
  - `volumes`: Utiliza un volumen persistente para almacenar los datos de MongoDB, asegurando que no se pierdan cuando el contenedor se detiene o se elimina.