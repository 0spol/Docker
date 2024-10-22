# PostgreSQL

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos PostgreSQL.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y navega a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará la imagen de PostgreSQL, arrancará el contenedor y configurará el entorno para su uso.

### Acceso a PostgreSQL

- **URL de acceso**: PostgreSQL se ejecuta en `http://localhost:5432`.
- **Credenciales**:
  - **Usuario**: `postgres`
  - **Contraseña**: `postgres`
  - **Base de datos**: `postgres`
  
Puedes utilizar cualquier cliente PostgreSQL, como **pgAdmin**, **DBeaver** o la línea de comandos (`psql`), para conectarte usando estas credenciales.

Si usas IntelliJ o Visual Studio, recomiendo descargar un plugin para facilitar la gestión de bases de datos. Para IntelliJ, se puede utilizar **Database Navigator**, y para Visual Studio, **JDBC Client**.

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se debe ejecutar el contenedor y su configuración específica.

```yaml
services:
  db:
    container_name: postgres-latest
    build: .
    ports:
      - "5432:5432"
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: postgres
      PGDATA: /var/lib/postgresql/data/pgdata
    volumes:
      - pgdata:/var/lib/postgresql/data
    networks:
      - my_network

volumes:
  pgdata:

networks:
  my_network:
    driver: bridge
```

### Detalles de la configuración

- **PostgreSQL**:
  - `image: postgres:latest`: Utiliza la última imagen de PostgreSQL.
  - `container_name: postgres`: Asigna un nombre al contenedor de PostgreSQL.
  - `ports`: Mapea el puerto `5432` del contenedor al puerto `5432` de la máquina local, permitiendo conexiones desde el host.
  - `environment`: Define las variables de entorno necesarias para la configuración de la base de datos:
    - `POSTGRES_USER`: Nombre del usuario administrador (por defecto, `postgres`).
    - `POSTGRES_PASSWORD`: Contraseña para el usuario administrador.
    - `POSTGRES_DB`: Nombre de la base de datos inicial.
  - `volumes`: Utiliza un volumen persistente para almacenar los datos de PostgreSQL, asegurando que no se pierdan cuando el contenedor se detiene o se elimina.
