# Oracle Database

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos para Oracle Database.

## Uso

### Puesta en marcha

1. **Descargar la imagen de Oracle Database**:
   La imagen de Oracle Database no está disponible públicamente. Debes descargarla desde el sitio web de Oracle. 

   - **Registro en el sitio de Oracle**: 
     Visita [Oracle Technology Network](https://www.oracle.com/database/technologies/) y regístrate para obtener una cuenta gratuita si aún no tienes una.

   - **Descargar la imagen**:
     1. Navega a la sección de "Oracle Database".
     2. Encuentra la versión deseada (por ejemplo, Oracle Database 19c) y descarga el archivo `docker-images.zip`. Este archivo contiene los Dockerfiles necesarios para construir la imagen de Oracle Database.
     3. Extrae el contenido del archivo ZIP en tu máquina.

2. **Importar la imagen a Docker**:
   Después de extraer el archivo ZIP, deberías encontrar una carpeta llamada `dockerfiles` que contendrá los Dockerfiles necesarios. Usa los siguientes comandos para construir la imagen de Docker:

   ```bash
   cd /path/to/extracted/dockerfiles
   docker build -t oracle/database:19.3.0-se2 .
   ```

   Asegúrate de reemplazar `/path/to/extracted/dockerfiles` con la ruta real donde se encuentran los archivos extraídos.

3. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

4. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando arrancará el contenedor y configurará el entorno para su uso.

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