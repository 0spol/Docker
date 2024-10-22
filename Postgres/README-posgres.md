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