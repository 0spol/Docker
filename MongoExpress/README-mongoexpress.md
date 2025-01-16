# MongoDB con Mongo-Express

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos MongoDB con una interfaz web proporcionada por Mongo-Express.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará las imágenes de MongoDB y Mongo-Express, iniciará los contenedores y configurará el entorno para su uso.

### Acceso a MongoDB

- **URL de acceso**: MongoDB se ejecuta en `mongodb://localhost:27017`.
- **Credenciales**:
  - **Usuario**: `admin`
  - **Contraseña**: `admin123`

Puedes utilizar cualquier cliente MongoDB, como MongoDB Compass o la línea de comandos `mongosh`, para conectarte usando estas credenciales. Por ejemplo:

   ```bash
   mongosh mongodb://admin:admin123@localhost:27017
   ```

Si usas IntelliJ o Visual Studio Code, también puedes descargar un plugin para facilitar la gestión de bases de datos:
- Para IntelliJ, puedes usar **Database Navigator**.
- Para Visual Studio Code, instala **MongoDB for VS Code**.

### Acceso a Mongo-Express

- **URL de acceso**: Mongo-Express está disponible en `http://localhost:8081`.
- **Credenciales de Mongo-Express**:
  - **Usuario**: `admin`
  - **Contraseña**: `pass`

La interfaz web permite explorar y gestionar las bases de datos de forma sencilla.

---

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se deben ejecutar los contenedores y sus configuraciones específicas.

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

  mongo-express:
    image: mongo-express:latest
    container_name: mongo_express
    depends_on:
      - mongodb
    ports:
      - "8081:8081"
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: admin
      ME_CONFIG_MONGODB_ADMINPASSWORD: admin123
      ME_CONFIG_MONGODB_SERVER: mongodb

volumes:
  mongodb_data:
```

---

### Detalles de la configuración

1. **MongoDB**:
   - `image: mongo:latest`: Utiliza la última imagen oficial de MongoDB.
   - `container_name: mongodb_container`: Nombre asignado al contenedor de MongoDB.
   - `ports`: Mapea el puerto `27017` del contenedor al puerto `27017` de la máquina local, permitiendo conexiones desde el host.
   - `environment`: Configura las credenciales del administrador:
     - `MONGO_INITDB_ROOT_USERNAME`: Usuario administrador.
     - `MONGO_INITDB_ROOT_PASSWORD`: Contraseña del administrador.
   - `volumes`: Utiliza un volumen persistente (`mongodb_data`) para asegurar que los datos de MongoDB no se pierdan al detener o eliminar el contenedor.

2. **Mongo-Express**:
   - `image: mongo-express:latest`: Utiliza la última imagen oficial de Mongo-Express.
   - `container_name: mongo_express`: Nombre asignado al contenedor de Mongo-Express.
   - `depends_on`: Garantiza que el contenedor de MongoDB se inicie antes que el de Mongo-Express.
   - `ports`: Mapea el puerto `8081` del contenedor al puerto `8081` de la máquina local, permitiendo acceso a la interfaz web.
   - `environment`: Configura las credenciales de acceso a la base de datos y el servidor MongoDB:
     - `ME_CONFIG_MONGODB_ADMINUSERNAME`: Usuario administrador para acceder a MongoDB desde Mongo-Express.
     - `ME_CONFIG_MONGODB_ADMINPASSWORD`: Contraseña del administrador.
     - `ME_CONFIG_MONGODB_SERVER`: Nombre del servicio de MongoDB (debe coincidir con el nombre del contenedor o servicio en `docker-compose.yml`).

3. **Volúmenes**:
   - `mongodb_data`: Define un volumen persistente para MongoDB que almacena los datos de la base de datos en el host.

---

### Notas adicionales

- Asegúrate de que los puertos `27017` y `8081` estén libres en tu máquina antes de ejecutar el entorno.

