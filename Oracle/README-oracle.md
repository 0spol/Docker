# Oracle Database

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos para Oracle Database.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

### Acceso a Oracle Database

- **URL de acceso**: Oracle Database se ejecuta en `localhost:1521`.
- **Credenciales**:
  - **Usuario SYS**: `SYS`
  - **Contraseña**: `mysecurepassword`
  - **Base de datos**: `mydatabase`
  - **Usuario adicional**: `myuser`
  - **Contraseña del usuario adicional**: `userpassword`
  
Puedes utilizar cualquier cliente de Oracle, como SQL Developer o DBeaver, para conectarte usando estas credenciales.

Si usas IntelliJ o Visual Studio, recomiendo descargar un plugin para facilitar la gestión de bases de datos. Para IntelliJ, se puede utilizar **Database Navigator**, y para Visual Studio, **JDBC Client**.